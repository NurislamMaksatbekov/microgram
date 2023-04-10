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
    like: 0,
    userId: 1, // я добавил в него userId. так и я связал его с пользователем

};

const comment = {
    id: 1,
    textOfComment: 'Cool bro',
    timeOfComment: date(),
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


function showSplashScreen(){
    content.hidden = true;
}

function hideSplashScreen(){
    content.hidden = false;
}








