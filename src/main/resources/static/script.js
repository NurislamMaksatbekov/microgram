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
let like = document.createElement('i');
const save = document.createElement('i');
const image = document.createElement('img');
const comment = document.createElement('i');
const modal = document.getElementById('my-modal');
const btn = document.getElementById('btn');
const button = document.getElementById('button');
const commentModal = document.getElementById('comment-modal');
const register = document.getElementById('register-btn');
const registerModal = document.getElementById('register-modal');
const name = document.getElementById('inputName')[0].value;
const username = document.getElementById('inputUsername')[0].value;
const email = document.getElementById('inputEmail')[0].value
const password = document.getElementById('inputPassword')[0].value


button.onclick = function () {
    btn.style.display = "block"
    register.style.display = "block"
    button.style.display = "none";

    showPosts();
}

btn.onclick = function () {
    modal.style.display = "block";
}

window.onclick = function (e) {
    if (e.target === modal || e.target === commentModal || e.target === registerModal) {
        modal.style.display = "none";
        commentModal.style.display = "none";
        registerModal.style.display = "none";
    }
}

comment.onclick = function () {
    commentModal.style.display = "block"
}

register.onclick = function () {
    registerModal.style.display = "block";
}

    async function registration(){
        addEventListener("submit", (e) =>{
            e.preventDefault();

            const form = e.target;

            const data = new FormData(form)

            data.append('name', name)
            data.append('username', username)
            data.append('email', email)
            data.append('password', password);

        })
    }





function showPosts() {
    const container = document.createElement('div');
    container.style.backgroundColor = "lightgray";
    container.style.width = "400px"
    container.style.height = "480px";
    container.style.marginLeft = "500px";
    container.style.marginBottom = "50px";

    image.style.width = "400px";
    image.style.height = "500x";
    image.classList.add('image');
    image.src = "https://toppeoples.ru/wp-content/uploads/2021/03/Le3mpmWeD0w.jpg"
    container.appendChild(image);

    const description = document.createElement('p');
    description.textContent = 'Na chile)';
    description.style.marginLeft = "10px";
    container.appendChild(description);

    const actions = document.createElement('div');
    actions.style.height = "400px"
    actions.style.borderTop = "1px solid darkgray";
    container.appendChild(actions);

    like.innerHTML = `<i class="bi bi-suit-heart"></i>`;
    like.style.marginLeft = "10px";
    actions.appendChild(like);

    comment.innerHTML = '<i class="bi bi-chat"></i>'
    comment.style.marginLeft = "10px";
    actions.appendChild(comment);

    save.innerHTML = '<i class="bi bi-bookmark"></i>';
    save.style.marginLeft = "325px";
    actions.appendChild(save)

    document.body.appendChild(container);

    return container;
}



like.addEventListener('click', () => {
    if (post.like) {
        like.innerHTML = `<i class="bi bi-suit-heart"></i>`;
        post.like = false
    } else {
        like.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`;
        post.like = true;
    }
})

save.addEventListener('click', () => {
    if (post.save) {
        save.innerHTML = `<i class="bi bi-bookmark"></i>`
        post.save = false;
    } else {
        save.innerHTML = `<i class="bi bi-bookmark-fill"></i>`;
        post.save = true;

    }
});

image.addEventListener('dblclick', () => {
    image.innerHTML = `<i class="bi bi-heart-fill"></i>`;
    if (!post.like) {
        like.innerHTML = `<i class="bi bi-suit-heart-fill"></i>`;
        post.like = true;
    }
});


