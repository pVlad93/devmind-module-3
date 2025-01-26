const BASE_API = "https://jsonplaceholder.typicode.com/";

export const getAllTodos = () => fetch(`${BASE_API}todos`);
export const getUserDetails = userId => fetch(`${BASE_API}users/${userId}`);