// let array = [];
// for (let i=0, j=3; i<j; i++) {
//     array.push(Math.round(Math.random() * 100))
// }

function getRandomNumber(max) {
    return Math.floor(Math.random() * (max + 1));
  }
  

function getRandomProblem() {
    return {
        numberOne: getRandomNumber(10),
        numberTwo: getRandomNumber(10),
        operator: ['x'][0]
    }
}
let rightAnswer=0;
let probNumber=1;
let score=0;

function checkAnswer(clicked, rightAnswer){
    //listen for click on all 4 buttons
    //if inner text of button clicked = right answer, add 1 to "currentScore" and advance
    //if incorrect, just skip to next
    let answerClicked=clicked;
    console.log("inner text clicked= "+answerClicked+" current right answer= "+rightAnswer)
    if (answerClicked==rightAnswer){
        console.log("right answer")
        score=score+1;
        probNumber=probNumber+1;
        scoreTally(score, probNumber)
    }else {
        console.log("Wrong Answer")
        probNumber=probNumber+1;
        scoreTally(score, probNumber)
        
    }
updateProblem();
}  

function scoreTally(score, probNumber){
    //counts problem #'s, increases "currentProblem" 1/10 text (2/10, 3/10, etc)
    //if currentProblem = 10, show final results screen with score (hides intro, problem, and answert buttons)
    document.querySelector(".currentScore").innerText=score;
    document.querySelector(".currentProblem").innerText=probNumber;
        if (probNumber>10){
           //let probNumber=10;
           document.querySelector(".currentProblem").innerText=10;
           document.getElementById("toCalculate").setAttribute("class","hidden")
           document.getElementById("answers").setAttribute("class","hidden")
        let toHide=document.getElementsByClassName("show-hide");
        for (var i in toHide) {
            if (toHide.hasOwnProperty(i)) {
              toHide[i].className = 'hidden';
            }
          }

        }
}

function startOver(){
    let score= document.querySelector(".currentScore");
    score.innerText=0;
    score=0;
    updateProblem()
    location.reload()
    //location.reload() //we were overthinking it. this just refreshes the page.
}

function updateProblem() {
    let multiplication = document.getElementById("toCalculate");
        newMath = getRandomProblem();
        multiplication.innerText = `${newMath.numberOne} ${newMath.operator} ${newMath.numberTwo}`;
        rightAnswer = (newMath.numberOne)*(newMath.numberTwo);
         //gets correct answer for currently shown problem
        let wrongAnswers = [];
        for (let i=0, j=3; i<j; i++) {
            wrongAnswers.push(Math.round(Math.random() * 100))
        }
        wrongAnswers.push(rightAnswer); //adds correct answer to array
        wrongAnswers.sort(); 
       for (i=0; i<wrongAnswers.length;i++){ //adds each possible answer to button text
            let li =document.getElementsByTagName('li');
            li[i].innerText=wrongAnswers[i];
        }
        
        console.log("rightAnswer= "+rightAnswer)
  
  };

document.addEventListener('DOMContentLoaded', () => {
updateProblem() 
scoreTally(score, probNumber)
});