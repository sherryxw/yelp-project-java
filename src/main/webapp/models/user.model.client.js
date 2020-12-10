function User(username, password, firstName, lastName, role) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.firstname = firstName;
    this.lastname = lastName;

    this.setUsername = setUsername;
    this.setFirstName = setFirstName();
    this.setLastName = setLastName();
    this.setPassword = setPassword();

    this.getRole = getRole();
    this.getLastName = getLastName()
    this.getFirstName = getFirstName()
    this.getPassword = getPassword()
    this.getUserName = getUsername()



    function setUsername(username) {
        this.username = username;
    }
    function setPassword(newPassword) {
        this.password = newPassword;
    }
    function setFirstName(firstname) {
        this.firstname = firstname;
    }
    function setLastName(lastname) {
        this.lastname = lastname;
    }
    function getUsername() {
        return this.username;
    }
    function getPassword() {
        return this.password;
    }
    function getFirstName() {
        return this.firstname;
    }
    function getLastName() {
        return this.lastname;
    }
    function getRole() {
        return this.role;
    }


}
