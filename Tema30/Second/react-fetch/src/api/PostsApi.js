const BASE_API = "https://jsonplaceholder.typicode.com/"

export const getAllPosts = () => fetch(`${BASE_API}posts`);
export const getPostComments = (postId) => fetch(`${BASE_API}comments?postId=${postId}`);