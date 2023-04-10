const user = {
    id: 1,
    naame: 'Nurislam',
    username: 'maksatbekov',
    email: 'maksatbekov@mail.ru',
    password: 'password',
    checkUser: false // если поле checkUser возвращает false то он не авторизован, а если true то наоборот

};

const post = {
    id: 1,
    image: 'beautifulimage',
    description: 'description',
    timeOfPost: new Date(),
    like: 0,
    userId: 1, // я добавил в него userId. так и я связал его с пользователем

};

const comment = {
    id: 1,
    textOfComment: 'Cool bro',
    timeOfComment: new Date(),
    userId: 1,
    postId: 1 // также я добавил id пользователя и поста чтобы саязять их

};


const posts = [];

function addPost(post){
    posts.push(post);
}


function changeUserStatus(user) {
    user.checkUser = true;
}

function changePostLikedStatus(postId) {
    const post = posts.find(post => post.id === postId);
    if (post) {
        post.likes = post.likes ? 0 : 1; // функция changePostLikedStatus ищет id поста в массиве posts и изменяет likes
        // если likes = 0 он меняет его значение на 1 или наоборотю
    }
}

// TASK1
function showSplashScreen(){
    const content = document.createElement('div')
    content.classList.add()
    document.body.appendChild(content)
}

function hideSplashScreen(){
    const content = document.getElementById('div')
    content.classList.remove();
}



// TASK 2

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
    userElement.textContent = comment.userId;

    commentElement.appendChild(textElement);
    commentElement.appendChild(timeElement);
    commentElement.appendChild(userElement);

    document.body.appendChild(commentElement)

    return commentElement;
}


// TASK 3

function createPostElement(post) {
    const postElement = document.createElement('div');

    const imageElement = document.createElement('img');
    imageElement.src = post.image;

    const descriptionElement = document.createElement('p');
    descriptionElement.textContent = post.description;

    const timeElement = document.createElement('span');
    timeElement.textContent = post.timeOfPost;

    const userElement = document.createElement('span');
    userElement.textContent = post.userId;

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

// TASK4

function addPost(postElement) {
    const postsContainer = document.getElementById('post');
    postsContainer.appendChild(postElement);

    document.body.appendChild(postsContainer)
}












