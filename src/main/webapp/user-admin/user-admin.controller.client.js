(function (eventData, handler) {

// let users = [
//     {
//         username: 'lee',
//         fName: 'Tim',
//         lName: 'Birns Lee',
//         role: 'FACULTY'
//     },
//     {
//         username: 'alovelace',
//         fName: 'Ada',
//         lName: 'Lovelace',
//         role: 'FACULTY'
//     },
//     {
//         username: 'cgarcia',
//         fName: 'Charlie',
//         lName: 'Garcia',
//         role: 'STUDENT'
//     },
//     {
//         username: 'dcraig',
//         fName: 'Dan',
//         lName: 'Craig',
//         role: 'STUDENT'
//     },
//     {
//         username: 'sbolivar',
//         fName: 'Simon',
//         lName: 'Bolivar',
//         role: 'FACULTY'
//     }
// ]
//declare
let tbody
let template
let clone
let $createBtn
let $searchBtn
let $usernameFld, $firstNameFld, $lastNameFld, $roleFld, $passwordFld
const userService = new AdminUserServiceClient();


const container = $(".container") //grab the container

const deleteUser1 = (event) => {
    const deleteBtn = $(event.currentTarget)
    //deleteBtn.parent().parent().parent().remove()
    //find wbdv-template, and delete
    deleteBtn.parents("tr.wbdv-template").remove()
}

const deleteUser = (_index) => {
    const user = users[_index]
    const id = user._id
    userService.deleteUser(id)
        .then(response => {
            users.splice(_index, 1)
            //re-render
            renderUsers(users)
        })
}
let selectedUserIndex = -1
const selectUser = (index) => {
    selectedUserIndex = index
    $("#usernameFld").val(users[index].username)
    $("#firstNameFld").val(users[index].first)
    $("#lastNameFld").val(users[index].last)
    $("#roleFld").val(users[index].role)
}

const renderUser = (user, index) => {
    clone.find(".wbdv-username").html(user.username)   //replace the contents
    clone.find(".wbdv-first-name").html(user.first)
    clone.find(".wbdv-last-name").html(user.last)
    clone.find(".wbdv-role").html(user.role)
    clone.find('.wbdv-remove').click(() => deleteUser(index)) //postpone, revoke later
    clone.find(".wbdv-edit").click(() => selectUser(index))
}

const renderUsers = (users) => {
    tbody.empty() //clean up the body
    const ul = $("<ul>") //create new ul
    for(let i = 0; i < users.length; i ++) {
        const user = users[i]
        const li = $("<li>" + user.username + "</li>")
        ul.append(li) //append li in ul
        clone = template.clone()
        clone.removeClass("wbdv-hidden") //hidden the template
        renderUser(user, i)
        tbody.append(clone)
    }
    container.append(ul) //append ul to the container
}


const findAllUsers = () => {
    userService.findAllUsers()
        .then((_users) => { //notify if the data i
            users = _users
            renderUsers(users)
        })
}

const findUserById = (userId) => {
    return userService.findUserById(userId)
}


const createUser = () => {
    const username = $usernameFld.val()
    const firstName = $firstNameFld.val()
    const lastName = $lastNameFld.val()
    const role = $roleFld.val()

    $usernameFld.val("")
    $firstNameFld.val("")
    $lastNameFld.val("")

    const newUser = {
        username: username,
        first: firstName,
        last: lastName,
        role: role
    }
    userService.createUser(newUser)
        .then(actualNewUser => {
            users.push(actualNewUser)
            renderUsers(users)
    })
}



const updateUser = () => {
    const newUserName = $("#usernameFld").val()
    const newFirstName = $("#firstNameFld").val()
    const newLastName = $("#lastNameFld").val()
    const newRole = $("#roleFld").val()
    const userId = users[selectedUserIndex]._id
    userService.updateUser(userId, {
        username: newUserName,
        first: newFirstName,
        last: newLastName,
        role: newRole
    })
        .then(response => {
            users[selectedUserIndex].username = newUserName
            users[selectedUserIndex].first = newFirstName
            users[selectedUserIndex].last = newLastName
            users[selectedUserIndex].role = newRole
            renderUsers(users)
        })
}

const searchHelper = (oldVal, newVal) => {
    if (newVal === "" || newVal === "Faculty") return true
    else return oldVal === newVal;
}

const searchUser = () => {
    const userName = $("#usernameFld").val()
    const firstName = $("#firstNameFld").val()
    const lastName = $("#lastNameFld").val()
    const role = $("#roleFld").val()
    const searchList = []
    userService.findAllUsers()
        .then((userList) => {
            for (let i = 0; i < userList.length; i++) {
                if (searchHelper(userList[i].username, userName) && searchHelper(userList[i].first, firstName)
                    && searchHelper(userList[i].last, lastName) && searchHelper(userList[i].role, role)) {
                    searchList.push(userList[i])
                }
            }
            renderUsers(searchList)
        })
}

const main = () => {
    const heading1 = jQuery("h1")
    heading1.css("color", "navyblue")
        .css("background", "lightblue")
        .html("User Administrator")
        .append(" - Only for Administrators.")
        .append("<button>OK</button>")

    tbody = $("tbody") //grab the body
    template = $("tr.wbdv-template")
    $firstNameFld = $("#firstNameFld")
    $lastNameFld = $("#lastNameFld")
    $usernameFld = $("#usernameFld")
    $roleFld = $("#roleFld")
    $searchBtn = $(".wbdv-search").click(searchUser)
    $createBtn = $(".wbdv-create").click(createUser)
    $(".wbdv-update").click(updateUser)
    //renderUsers(users)
    findAllUsers()
}
$(main)


})()
