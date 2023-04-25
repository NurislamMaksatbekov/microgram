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
        const postId = comment.post

        commentModal.style.display = "block"
    }
    commentIcon.addEventListener('click', showCommentaries)

    register.onclick = function () {
        registerModal.style.display = "block"
    }

    return container


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
    const response = await fetch( 'http://localhost:9889/posts/showPosts')
        .then(response => {
            return response.json()
        })
    for (let i = 0; i < response.length; i++) {
        makePosts(response[i])
    }
    console.log(response)
}

const commentaries = document.createElement('p')
function makeCommentaries(comment){
    const container = document.createElement('div')
    commentaries.textContent = comment.textOfComment
    container.appendChild(commentaries)
}

async function showCommentaries() {
    const comments = commentaries.value
     comment = {
        commentaries: comments
    }
    const userJSON = JSON.stringify(comments)
    console.log(userJSON)
    const response = await fetch( 'http://localhost:9889/comments/postComment')
        .then(response => {
            return response.json()
        })
    for (let i = 0; i < response.length; i++) {
        makeCommentaries(response[i])
    }
    console.log(response)
}

const btn = document.getElementById('btn')
const button = document.getElementById('button')

const register = document.getElementById('register-btn')
button.onclick = function () {
    btn.style.display = "block"
    register.style.display = "block"
    button.style.display = "none"
}

button.addEventListener('click', showPosts)

const modal = document.getElementById('my-modal')
btn.onclick = function () {
    modal.style.display = "block"
}

const commentModal = document.getElementById('comment-modal')
const registerModal = document.getElementById('register-modal')
window.onclick = function (e) {
    if (e.target === modal || e.target === commentModal || e.target === registerModal) {
        modal.style.display = "none"
        commentModal.style.display = "none"
        registerModal.style.display = "none"
    }
}









