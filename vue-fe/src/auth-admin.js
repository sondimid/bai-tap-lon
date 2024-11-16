export default async function ({redirect }) {
    let userInfor = JSON.parse(localStorage.getItem("userInfor"));
    if (userInfor && userInfor.role == 'ADMIN') {
        redirect('/admin')
    }
    else {
        redirect('/')
    }
}