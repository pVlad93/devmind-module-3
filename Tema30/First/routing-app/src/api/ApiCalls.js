const BASE_API = "https://api.github.com/users/";

export const getUser = (user) => fetch(`${BASE_API}${user}`);
export const getUserRepos = (user) => fetch(`${BASE_API}${user}/repos`);