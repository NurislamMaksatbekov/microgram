const post = {
    id: 1,
    image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlros2f-2PIRzeI3-1FYsdqiyeRZHAy5MFfw&usqp=CAU',
    description: 'description',
    timeOfPost: new Date(),
    like: 0,
    isLiked: false,
    commentIcon: '',
    saveIcon: '',
    // user: user
};

const modal = document.getElementById('my-modal');
const btn = document.getElementById('btn');
const span = document.getElementsByClassName("close")[0];
const button = document.getElementById('button');

button.onclick = function (){
    btn.style.display = "block"
    button.style.display = "none";
}

btn.onclick = function (){
    modal.style.display = "block";
}
span.onclick = function (){
    modal.style.display = "none";
}

window.onclick = function (event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}
function posts(){

}

async function showPosts(){

}


