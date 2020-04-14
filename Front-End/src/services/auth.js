export const NAME = "authenticatedUserName"
export const getName = () => localStorage.getItem(NAME)
export const nameUser = name => {
    localStorage.setItem(NAME, name)
}
export const TOKEN_KEY = "token"
export const isAuthenticated = () => localStorage.getItem(TOKEN_KEY) !== null
export const getToken = () => localStorage.getItem(TOKEN_KEY)
export const login = token => {
    localStorage.setItem(TOKEN_KEY, token)
}
export const logout = () => {
    localStorage.removeItem(TOKEN_KEY);
}