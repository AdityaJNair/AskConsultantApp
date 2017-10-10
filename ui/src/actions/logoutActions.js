// Empty the token in he loginInfo
export const logout = () => {
    return {
        type: 'USER_LOGOUT',
        token: ''
    }
}