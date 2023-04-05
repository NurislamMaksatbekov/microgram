// TASK1

const user = {
    id: 1,
    naame: 'Nurislam',
    username: 'maksatbekov',
    email: 'maksatbekov@mail.ru',
    password: 'password',
    checkUser: false // если поле checkUser возвращает false то он не авторизован, а если true то наоборот

};


// TASK2

const post = {
    id: 1,
    image: 'beautifulimage',
    description: 'description',
    like: 0,
    userId: 1, // я добавил в него userId. так и я связал его с пользователем

};


// TASK3

const comment = {
    id: 1,
    textOfComment: 'Cool bro',
    userId: 1,
    postId: 1 // также я добавил id пользователя и поста чтобы саязять их

};


// TASK4

const posts = [];

function addPost(post){
    posts.push(post);
}


// TASK5

function changeUserStatus(user) {
    user.checkUser = true;
}

function checkPostLikedStatus(postId) {
    const post = posts.find(post => post.id === postId);
    if (post) {
        post.likes = post.likes ? 0 : 1;
    }

}





