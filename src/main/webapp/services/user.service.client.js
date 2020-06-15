function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;

    // replace jannunzi with own unique id
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001452943/users'

    // this behaves differently in JS
    // this refers to the parent function (so UserServiceClient)
    var self = this;

    // if we used this as a parameter
    // it would reference createUser and not UserServiceClient
    function createUser(user) {
        console.log('creating user')
        console.log(user)
        const userString = JSON.stringify(user)
        console.log(userString)

        // user is a JSON and not a string
        // needs to be a string
        return fetch(self.url, {
            method: 'POST',
            body: userString,
            headers: {
                // mind type is a universal standard
                // excel spreedsheets, movies, etc. all have a mind type
                'content-type': 'application/json'
            }
        })
            .then(function (response) {
                return response.json()
            })
    }

    function findAllUsers() {
        // console.log("find all users")
        // return ['some user']
        // cannot do this.url 
        // returns Promise on DOM
        // asychronous communication between client and server
        // Sending request and then not waiting for response
        // So it does other things at the same time
        // JS does not have multi threads
        // Dangerous to send request and then wait 
        // Not efficient
        // fetch is a get request
        return fetch(self.url)
            .then(function (response) {
                // Another promise
                // console.log(response)
                return response.json()
            })
    }
    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function (response) {
                return response.json()
            })
    }
    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                // mind type is a universal standard
                // excel spreedsheets, movies, etc. all have a mind type
                'content-type': 'application/json'
            }
        })
            .then(function (response) {
                return response.json()
            })
    }

    function deleteUser(userId) {
        console.log('removing user: ' + userId)
        return fetch(self.url + '/' + userId, {
            method: 'DELETE'
        })
            .then(function (response) {
                return response.json()
            })
    }
}