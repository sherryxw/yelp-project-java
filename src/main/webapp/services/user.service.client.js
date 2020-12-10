function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001470035/users';
    var self = this;

    function findAllUsers() {
        //retrieve from server
        return fetch("https://wbdv-generic-server.herokuapp.com/api/001470035/users") //return a promise
            .then(response => response.json())  //parse the readable things
    }
    function createUser(user) {
        return fetch('https://wbdv-generic-server.herokuapp.com/api/001470035/users', {
            method: "POST",
            body: JSON.stringify(user),
            headers:{
                "content-type": "application/json"
            }
        }) //return a promise
            .then(response => response.json())
    }

    function findUserById(userId) {
        return fetch(`https://wbdv-generic-server.herokuapp.com/api/001470035/users/${userId}`) //return a promise
            .then(response => response.json())  //parse the readable things
    }

    function updateUser(userId, user) {
        return fetch(`https://wbdv-generic-server.herokuapp.com/api/001470035/users/${userId}`, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
    }
    function deleteUser(userId) {
        //fetch default is get, need to change to delete
        return fetch(`https://wbdv-generic-server.herokuapp.com/api/001470035/users/${userId}` , {
            method: 'DELETE'
        })
    }
}
