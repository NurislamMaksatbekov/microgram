let user = {
    id: 1,
    naame: '',
    username: '',
    email: '',
    password: '',
    checkUser: false
}

let post = {
    id: 1,
    image: '',
    description: '',
    timeOfPost: new Date(),
    like: 0,
    isLiked: false,
    user: user
}

let comment = {
    id: 1,
    textOfComment: '',
    timeOfComment: new Date(),
    user: user,
    post: post
}

const registerBtn = document.getElementById('register-button')
registerBtn.addEventListener("click", registration)
registerBtn.addEventListener('click', showPosts)

async function registration(e) {
    e.preventDefault()

    const naame = document.getElementById('inputName')
    const nameOfUser = naame.value

    const username = document.getElementById('inputUsername')
    const usernameOfUser = username.value

    const email = document.getElementById('inputEmail')
    const emailOfUser = email.value

    const password = document.getElementById('inputPassword')
    const passwordOfUser = password.value

    user = {
        naame: nameOfUser,
        username: usernameOfUser,
        email: emailOfUser,
        password: passwordOfUser
    }

    const userJSON = JSON.stringify(user)
    console.log(userJSON)
    const headers = {
        'Content-Type': 'application/json'
    }
    const response = await fetch('http://localhost:9889/users/register', {
        method: 'POST',
        body: userJSON,
        headers: headers
    })
    const responseData = await response.json()
    console.log(responseData)
}

const image = document.createElement('img')
const description = document.createElement('p')

function makePosts(post) {
    const container = document.createElement('div')
    if (logout.addEventListener('click', () => {
        container.remove()
    }))
        container.style.backgroundColor = "lightgray"
    container.style.width = "400px"
    container.style.height = "480px"
    container.style.marginLeft = "500px"
    container.style.marginBottom = "50px"

    const postImage = document.createElement('img')
    postImage.style.width = "100%"
    postImage.src = post.image
    container.appendChild(postImage)
    const descriptionBlock = document.createElement('div')
    container.appendChild(descriptionBlock)
    const postDescription = document.createElement('p')
    postDescription.textContent = post.description
    descriptionBlock.appendChild(postDescription)

    const actions = document.createElement('div')
    actions.style.height = "400px"
    actions.style.borderTop = "1px solid darkgray"
    container.appendChild(actions)

    const likeIcon = document.createElement('i')
    likeIcon.innerHTML = `<i class="bi bi-suit-heart"></i>`
    likeIcon.style.marginLeft = "10px"
    actions.appendChild(likeIcon)

    const commentIcon = document.createElement('i')
    commentIcon.innerHTML = '<i class="bi bi-chat"></i>'
    commentIcon.style.marginLeft = "10px"
    actions.appendChild(commentIcon)

    const saveIcon = document.createElement('i')
    saveIcon.innerHTML = '<i class="bi bi-bookmark"></i>'
    saveIcon.style.marginLeft = "325px"
    actions.appendChild(saveIcon)

    document.body.appendChild(container)

    likeIcon.addEventListener('click', () => {
        if (post.like) {
            likeIcon.innerHTML = `<i class="bi bi-suit-heart"></i>`
            post.like = false
        } else {
            likeIcon.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`
            post.like = true
        }
    })

    image.addEventListener('dblclick', () => {
        image.innerHTML = `<i class="bi bi-heart-fill"></i>`
        if (!post.like) {
            likeIcon.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`
            post.like = true
        }
    })

    saveIcon.addEventListener('click', () => {
        if (post.save) {
            saveIcon.innerHTML = `<i class="bi bi-bookmark"></i>`
            post.save = false
        } else {
            saveIcon.innerHTML = `<i class="bi bi-bookmark-fill"></i>`
            post.save = true

        }
    })
    commentIcon.onclick = function () {
        commentModal.style.display = "block"
    }

    commentIcon.addEventListener('click', showCommentaries)


    return container
}

const register = document.getElementById('register-btn')
register.onclick = function () {
    registerModal.style.display = "block"
}


async function showPosts(e) {
    e.preventDefault()
    const images = image.value
    const descriptions = description.value
    post = {
        image: images,
        description: descriptions
    }
    const userJSON = JSON.stringify(post)
    console.log(userJSON)
    const response = await fetch('http://localhost:9889/posts/showPosts')
        .then(response => {
            return response.json()
        })
    for (let i = 0; i < response.length; i++) {
        makePosts(response[i])
    }
    btn.style.display = "block"
    logout.style.display = "block"
    loginModal.style.display = "none"
    register.style.display = "none"
    loginBtn.style.display = "none"
    registerModal.style.display = "none"
    console.log(response)
}

async function getComments(postId) {
    const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}/comments`);
    return await response.json();
}

async function showCommentaries(postId) {
    const comments = await getComments(postId);
    const commentsList = document.getElementById(`comments-${postId}`);
    comments.forEach((comment) => {
        const li = document.createElement('li');
        li.classList.add('comment');
        li.innerHTML = `<p><b>${comment.body}</b></p><p>${comment.body}</p>`;
        commentsList.appendChild(li);
    });
}

const btn = document.getElementById('btn')
const loginBtn = document.getElementById('login-btn')


loginBtn.onclick = function () {
    loginModal.style.display = "block"
}

const modal = document.getElementById('my-modal')
btn.onclick = function () {
    modal.style.display = "block"
}
const loginModal = document.getElementById('login-modal')
const commentModal = document.getElementById('comment-modal')
const registerModal = document.getElementById('register-modal')
window.onclick = function (e) {
    if (e.target === modal || e.target === commentModal || e.target === registerModal || e.target === loginModal) {
        modal.style.display = "none"
        commentModal.style.display = "none"
        registerModal.style.display = "none"
        loginModal.style.display = "none"
    }
}


const authBtn = document.getElementById('login-button')
authBtn.addEventListener("click", showPosts)
authBtn.addEventListener('click', saveUser)


const loginForm = document.getElementById('login-form');

function saveUser(user) {
    localStorage.setItem('user', JSON.stringify(user));
}

function getUser() {
    return JSON.parse(localStorage.getItem('user'));
}

function fetchAuthorized(url, options = {}) {
    const headers = {
        'Content-Type': 'application/json',
    };
    const user = getUser();
    if (user) {
        headers.Authorization = 'Basic ' + btoa(`${user.username}:${user.password}`);
    }
    options.headers = headers;
    options.mode = 'cors';
    return fetch(url, options);
}

function onLoginHandler(e) {
    e.preventDefault();
    const userFormData = new FormData(loginForm);
    const user = Object.fromEntries(userFormData);
    saveUser(user);
    fetchAuthorized(BASE_URL + 'posts');
}

loginForm.addEventListener('submit', onLoginHandler);


const logout = document.getElementById('logout-btn')

logout.addEventListener('click', logoutUser)

function logoutUser() {
    btn.style.display = "none"
    logout.style.display = "none"
    register.style.display = "block"
    loginBtn.style.display = "block"
    return localStorage.removeItem('user')
}
if(getUser() !== null){
    showPosts()
}else {
    loginModal.style.display = "block"
}




