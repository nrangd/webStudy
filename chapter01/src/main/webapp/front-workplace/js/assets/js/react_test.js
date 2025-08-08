const cards = {
    test_ready: testReadyComp(),
    test_wait: document.getElementById('test-wait'),
    test_wait_click: document.getElementById('test-wait-click'),
    test_clicked: document.getElementById('test-clicked'),
    test_finish: '',
    test_record: document.getElementById('test-record')
}

const main = document.getElementById('main');
const progressBar = document.getElementById('progress-bar');
const progressBarText = document.getElementById('progress-bar-text');
const progressBarIn = document.getElementById('progress-bar-in');

// 처음 화면 세팅
replaceCard(cards.test_wait);
replaceCard(cards.test_wait_click);
replaceCard(cards.test_clicked);
replaceCard(cards.test_record);
replaceCard(cards.test_ready);

let measureResults = [];

const getRecords = () => {
    const records = {
        max: -1,
        min: -1,
        avg: -1,
    }
    let sum = 0;
    for (r of measureResults) {
        records.max = records.max === -1 ? r : records.max > r ? records.max : r;
        records.min = records.min === -1 ? r : records.min < r ? records.max : r;
        sum += r;
    }
    records.avg = sum / 5;

    return records;
}

// start-button이 생기기 전에 부르는 것을 주의해야 한다
const startBtn = document.getElementById('start-button');

const startWaitHandler = (e) => {
    replaceCard(cards.test_wait);
    main.classList.remove('measure-end');
    main.classList.add('waiting');
    waitClick();
};

const restartWaitHandler = (e) => {
    replaceCard(cards.test_wait);
    main.classList.remove('finish');
    main.classList.add('waiting');
    measureResults = [];
    
    progressBarText.innerText = `${measureResults.length} / 5`;
    progressBarIn.style.width = '1%';
    waitClick();
};

startBtn.addEventListener('click', startWaitHandler);

let measure_start_time;
let measure_end_time;

let measure_id;
let tooFastClickHandler;

function waitClick() {
    main.removeEventListener('click', startWaitHandler);
    
    // 측정 대기 시작
    measure_id = window.setTimeout(measureStart, parseInt(Math.random()* 4500 + 500));

    tooFastClickHandler = () => {
        clearTimeout(measure_id);   // 돌아가고 있던 측정 대기 타임아웃 제거
        main.removeEventListener('click', tooFastClickHandler); // '너무빨리클릭' 이벤트 제거
        alert('Fail! Clicked too early');   // 경고창
        main.classList.remove('waiting');   // 배경색 바꾸기
        measureResults = []; // 여태까지의 기록 다 날리기
        progressBarText.innerText = `${measureResults.length} / 5`;
        progressBarIn.style.width = `1%`;
        replaceCard(cards.test_ready);
    };

    window.setTimeout(() => {
        main.addEventListener('click', tooFastClickHandler)
    }, 10);
}

// // 측정이 시작 될 때 메인에 잠시 이벤트 붙이기
// const measureStartHandler = (e) => {
//     measureEnd();
// };

function measureStart() {
    replaceCard(cards.test_wait_click);
    main.classList.remove('waiting');
    measure_start_time = new Date().getTime(); // 측정 시작
    main.removeEventListener('click', tooFastClickHandler);
    main.addEventListener('click', measureEnd);
}

function measureEnd() {
    measure_end_time = new Date().getTime(); // 측정 완료
    const result = (measure_end_time - measure_start_time);
    measureResults.push(result);
    progressBarText.innerText = `${measureResults.length} / 5`;
    progressBarIn.style.width = `${measureResults.length / 5 * 100}%`;
    
    // 5번의 게임이 진행되는 동안 결과를 누적시킴
    if (measureResults.length < 5) {
        const to_show = cards.test_clicked;
        to_show.querySelector('.millisec').innerText = `${result} ms`;
        main.classList.add('measure-end');
        replaceCard(to_show);
    
        // main.removeEventListener('click', measureStartHandler);
        main.removeEventListener('click', measureEnd);
        main.addEventListener('click', startWaitHandler);
    } else {
        // 5번의 결과가 나온 뒤 통계화면으로 넘어감과 동시에 여지껏 누적된 결과를 출력함
        const to_show = cards.test_record;

        const records = getRecords();

        to_show.querySelector('.avg-time > .millisec').innerText = records.avg;
        to_show.querySelector('.best-time > .millisec').innerText = records.min;
        to_show.querySelector('.worst-time > .millisec').innerText = records.max;

        main.classList.add('finish');
        replaceCard(to_show);

        // 결과창을 띄운 후 결과창의 버튼에 시작버튼과 동일한 기능넣기
        const restartBtn = document.getElementById('restart-button');
        restartBtn.removeEventListener('click', restartWaitHandler);
        restartBtn.addEventListener('click', restartWaitHandler);

        main.removeEventListener('click', measureEnd);
    }
}

// 클릭 화면에 이벤트 달기
// cards.test_wait_click.addEventListener('click', (e) => {
//     measure_end_time = new Date().getTime(); // 측정 완료

//     const to_show = cards.test_clicked;
//     const result = (measure_end_time - measure_start_time);

//     measureResults.push(result);
//     to_show.querySelector('.millisec').innerText = `${result} ms`;

//     replaceCard(to_show);
// });

function replaceCard(card) {
    // firstChild는 첫 번째 노드를 가져온다 (텍스트 노드도 포함)
    // firstElementChild는 첫 번째 요소를 가져온다
    const currCard = main.firstElementChild;
    // console.log(currCard);
    main.replaceChild(card, currCard);
}

function testReadyComp() {
    const wrapper = document.createElement('div');
    wrapper.id = 'test-ready';

    const icon = document.createElement('div');
    icon.classList.add('main-icon');
    wrapper.appendChild(icon);

    const title = document.createElement('div');
    const titleText = document.createTextNode("React Time Test");
    title.classList.add('title');
    title.appendChild(titleText);
    wrapper.appendChild(title);

    const button = document.createElement('div');
    const buttonText = document.createTextNode('Start');
    button.id = 'start-button';
    button.classList.add('test-start-button');
    button.appendChild(buttonText);
    wrapper.appendChild(button);

    return wrapper;
}