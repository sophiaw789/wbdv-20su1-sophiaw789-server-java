// Wrapping everything in a function call is best practice
// because users and init would not be global
// lambda function (nameless)
// Parenthesis at the end, envoke/execute right when it loads
// Envokes whatever is to the left of it
(function () {
    //JSON - JavaScript Object Notation
    let users = [
        { username: 'alice', password: 'alice', first: 'Alice', last: 'Wonderland', role: "FACULTY" },
        { username: 'bob', password: 'bob', first: 'Bob', last: 'Marley', role: "FACULTY" },
        { username: 'charlie', password: 'charlie', first: 'Charlie', last: 'Garcia', role: "STUDENT" }
    ]

    // const tbody = $('tbody') doesn't work because jQuery(main) is called at the end
    // when main() is called, guaranteed that DOM is fully loaded
    // $('tbody) no guarantee that the HTML document has fully loaded yet
    // tbody wouldn't exist yet
    // Goes top to bottom

    let $usernameFld, $passwordFld;
    let $firstNameFld, $lastNameFld, $roleFld;
    let $deleteBtn, $updateBtn, $addBtn;
    let $userTemplate, $tbody;
    let selectedUser = {}
    let userService = new AdminUserServiceClient();

    /*  
    Don't want to inadvertantly shadow other library functions and mess everything up
    function jQuery() {
        alert('jquery is now gone ... sorry')
    }
    */

    // CRUD for data: create, read, update, delete
    function deleteUser(event) {
        console.log(event)
        // this would return the raw DOM element
        const target = event.currentTarget
        const $button = $(target)
        // one argument is for reading 
        // two arguments are for writing
        const userId = $button.attr('id')

        userService.deleteUser(userId)
            .then(function () {
                // boolean: true -> keep
                // false -> remove
                users = users.filter(function (user) {
                    return user._id !== userId
                })
                renderAllUsers()
            })
    }

    function renderUser(user) {
        selectedUser = user
        // providing an argument is a write element
        // not providing an argument is a read element
        $usernameFld.val(user.username)
        $firstNameFld.val(user.first)
        $lastNameFld.val(user.last)
    }

    function updateUser() {
        const updatedUser = {
            _id: selectedUser._id,
            username: $usernameFld.val(),
            first: $firstNameFld.val(),
            last: $lastNameFld.val(),
            role: $roleFld.val()
        }

        userService.updateUser(selectedUser._id, updatedUser)
            .then(function (status) {
                users = users.map(function (user) {
                    if (user._id === selectedUser._id) {
                        return updatedUser
                    } else {
                        return user
                    }
                })
                renderAllUsers()
            })
    }

    function findUserById(event) {
        const target = event.currentTarget
        const $button = $(target)
        const userId = $button.attr('id')
        userService.findUserById(userId)
            .then(function (user) {
                console.log(user)
                renderUser(user)
            })
    }

    function renderAllUsers() {
        //console.log('rendering all users')
        //console.log(users)

        // Grabs it and returns an array

        // Creates memory copy of the object

        //console.log($template)
        // Remove all child elements inside the parent (top level) element
        $tbody.empty()
        /*
        for (let i = 0; i < users.length; i++) {
            const user = users[i]
            //console.log(user)
            const copy = clone.clone()
            //copy.removeClass('.wbdv-user-row-template')
            copy.find('.wbdv-username').html(user.username)
            copy.find('.wbdv-first-name').html(user.first)
            copy.find('.wbdv-last-name').html(user.last)
            copy.find('.wbdv-role').html(user.role)
            // Manipulating delete button
            // copy.find('.wbdv-delete').html('Remove Me' + user._id)
            copy.find('.wbdv-delete')
                .attr('id', user._id)
                .click(deleteUser)
            copy.find('.wbdv-edit')
                .attr('id', user._id)
                .click(findUserById)
            $tbody.append(copy)
        }
        */
        for (let u in users) {
            const user = users[u]
            const rowClone = $userTemplate.clone()
            rowClone.removeClass('wbdv-hidden')
            rowClone.find('.wbdv-username').html(user.username)
            rowClone.find('.wbdv-first-name').html(user.first)
            rowClone.find('.wbdv-last-name').html(user.last)
            rowClone.find('.wbdv-role').html(user.role)
            rowClone.find('.wbdv-delete')
                .attr('id', user._id)
                .click(deleteUser)
            rowClone.find('.wbdv-edit')
                .attr('id', user._id)
                .click(findUserById)
            $tbody.append(rowClone)
        }
    }

    // Better to define a specific function rather than a lambda
    function createUser() {
        console.log($usernameFld)
        const username = $usernameFld.val()
        const first = $firstNameFld.val()
        const last = $lastNameFld.val()
        const role = $roleFld.val()

        const newUser = {
            username: username,
            first: first,
            last: last,
            role: role
        }

        userService.createUser(newUser)
            .then(function (actualUser) {
                users.push(actualUser)
                renderAllUsers()
            })

        // this would not work
        // only updates the local array
        // does not save to the server
        // users.push(newUser)
        // renderAllUsers()
    }

    function findAllUsers() {
        userService.findAllUsers()
            .then(function (allUsers) {
                users = allUsers
                renderAllUsers()
            })
    }

    function main() {
        //binding them in the main function
        $tbody = $('tbody')
        $addBtn = $('.wbdv-add')
        $updateBtn = $('.wbdv-update')
        $deleteBtn = $('.wbdv-delete')
        //$addBtn.css('backgroundColor', 'yellow')

        // . is for classes
        // # is for ids
        $usernameFld = $('.wbdv-username-fld')
        $passwordFld = $('.wbdv-password-fld')
        $firstNameFld = $('.wbdv-first-name-fld')
        $lastNameFld = $('.wbdv-last-name-fld')
        $roleFld = $('.wbdv-role-fld')

        $userTemplate = $('.wbdv-template')

        $addBtn.click(createUser)
        $updateBtn.click(updateUser)
        $deleteBtn.click(deleteUser)

        findAllUsers()
        renderAllUsers()

        // fetch all H1 elements from HTML document
        //const h1 = jQuery('h1')
        //h1.css('color', 'red')

        //const tr = jQuery('tr')
        //tr.css('backgroundColor', 'blue').css('color', 'white')

        /*
        Outputs heading 2 of text and append to html body
        const h2 = jQuery('<h2>Hello from jQuery</h2>')
        const body = jQuery('body')
        body.append(h2)
        */

        //$ is an alias to the jQuery function
        /*
        const newTr = $('<tr><td>dan<t/td></tr>')
        $tbody.append(newTr)

        for (let i = 0; i < users.length; i++) {
            const username = users[i].username
            const newUserRow = $('<tr><td>' + username + '</td></tr>')
            $tbody.append(newUserRow)
        }
        */

        // renderAllUsers()
    }

    // Equivalent to our function init()
    jQuery(main)
})()