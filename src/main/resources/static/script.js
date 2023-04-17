const user = {
    id: 1,
    naame: 'Nurislam',
    username: 'maksatbekov',
    email: 'maksatbekov@mail.ru',
    password: 'password',
    checkUser: false

};

const post = {
    id: 1,
    image: 'img',
    description: 'description',
    timeOfPost: new Date(),
    like: 0,
    isLiked: false,
    commentIcon: '',
    saveIcon: '',
    user: user
};

const comment = {
    id: 1,
    textOfComment: 'Cool bro',
    timeOfComment: new Date(),
    user: user,
    post: post

};


const posts = [post];

function addPost(post){
    posts.push(post);
}


function changeUserStatus(user) {
    user.checkUser = true;
}

function changePostLikedStatus(post) {
    const postId = posts.find(post => post.id === post);
    if (postId) {
        postId.likes = postId.likes ? 0 : 1; // функция changePostLikedStatus ищет id поста в массиве posts и изменяет likes
        // если likes = 0 он меняет его значение на 1 или наоборотю
    }
}

function showSplashScreen(){
    const splashScreen = document.createElement('div')
    splashScreen.id = "splash-screen";
    splashScreen.style.position = "fixed";
    splashScreen.style.top = "0";
    splashScreen.style.left = "0";
    splashScreen.style.width = "100%";
    splashScreen.style.height = "100%";
    splashScreen.style.backgroundColor = "red";
    document.body.appendChild(splashScreen);
    return splashScreen;
}

function hideSplashScreen(){
    const splashScreen = document.getElementById('splash-screen');
    splashScreen.parentElement.removeChild(splashScreen);
}




function createCommentElement(comment) {
    const commentElement = document.createElement('div');
    commentElement.classList.add();

    const textElement = document.createElement('p');
    textElement.classList.add();
    textElement.textContent = comment.textOfComment;

    const timeElement = document.createElement('span');
    timeElement.classList.add();
    timeElement.textContent = comment.timeOfComment;

    const userElement = document.createElement('span');
    userElement.classList.add();
    userElement.textContent = comment.user.username;

    commentElement.appendChild(textElement);
    commentElement.appendChild(timeElement);
    commentElement.appendChild(userElement);

    document.body.appendChild(commentElement)

    return commentElement;
}



function createPostElement(post) {
    const postElement = document.createElement('div');

    const imageElement = document.createElement('img');
    imageElement.src = post.image;

    const descriptionElement = document.createElement('p');
    descriptionElement.textContent = post.description;

    const timeElement = document.createElement('span');
    timeElement.textContent = post.timeOfPost;

    const userElement = document.createElement('span');
    userElement.textContent = post.user.username;

    const commentElement = document.createElement('div');
    commentElement.classList.add();


    postElement.appendChild(imageElement);
    postElement.appendChild(descriptionElement);
    postElement.appendChild(timeElement);
    postElement.appendChild(userElement);
    postElement.appendChild(commentElement);

    document.body.appendChild(postElement)

    return postElement;
}

function addPost(postElement) {
    const postsContainer = document.getElementById('post');
    postsContainer.appendChild(postElement);

    document.body.appendChild(postsContainer)
}

let like = document.createElement('i');
const save = document.createElement('i');
const image = document.createElement('img');
const  btn = document.createElement('button')
btn.innerText = 'Login';
btn.id = 'show';
document.body.appendChild(btn);



like.addEventListener('click', ()=> {
    if (post.like){
        like.innerHTML = `<i class="bi bi-suit-heart"></i>`;
        post.like = false
    }else {
        like.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`;
        post.like = true;
    }
})

save.addEventListener('click', ()=>{
    if(post.save){
        save.innerHTML = `<i class="bi bi-bookmark"></i>`
        post.save = false;
    }
    else {
        save.innerHTML = `<i class="bi bi-bookmark-fill"></i>`;
        post.save = true;

    }
});

image.addEventListener('dblclick', ()=>{
    image.innerHTML = `<i class="bi bi-heart-fill"></i>`;
    if(!post.like){
        like.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`;
        post.like = true;
    }
})


function showPost(post) {
    const container = document.createElement('div');
    container.style.backgroundColor = "yellow";

    image.style.width = "400px";
    image.style.height = "500x";
    image.classList.add('image');
    image.src = "https://toppeoples.ru/wp-content/uploads/2021/03/Le3mpmWeD0w.jpg"
    container.appendChild(image);

    const actions = document.createElement('div');
    actions.style.height = "400px"
    container.appendChild(actions);

    like.innerHTML = `<i class="bi bi-suit-heart"></i>`;
    like.style.marginLeft = "10px";
    actions.appendChild(like);

    const comment = document.createElement('i');
    comment.classList.add('bi-chat');
    comment.style.marginLeft = "10px";
    actions.appendChild(comment);

    save.innerHTML = '<i class="bi bi-bookmark"></i>';
    save.style.marginLeft = "330px";
    actions.appendChild(save)

    document.body.appendChild(container);

    return container;
}

// TASK 4

const show = document.getElementById('show')

function showSplashScreen(){
    const splashScreen = document.createElement('div')
    showPost(post);
    document.body.appendChild(splashScreen);
    return splashScreen;

}
show.addEventListener('click', showSplashScreen);

