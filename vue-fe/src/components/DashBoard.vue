<template>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#"
                    @click="toDashBoardPage">
                    <div class="sidebar-brand-icon rotate-n-20">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-10">Trang Chủ</div>
                </a>

                <hr class="sidebar-divider my-0">

                <div class="sidebar-heading" id="headingSearch" style="font-size: larger;">
                    Tìm Kiếm Nhanh
                </div>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePrice"
                        aria-expanded="true" aria-controls="collapsePrice">
                        <i class="fas fa-money-bill-wave"></i>
                        <span>Tìm Theo Giá</span>
                    </a>
                    <div id="collapsePrice" class="collapse" aria-labelledby="headingPrice"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByPrice(0, 1)">Dưới 1 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(1, 2)">Từ 1 triệu đến 2
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(2, 3)">Từ 2 triệu đến 3
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(3, 5)">Từ 3 triệu đến 5
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(5, 7)">Từ 5 triệu đến 7
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(7)">Trên 7 triệu</a>
                        </div>
                    </div>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseArea"
                        aria-expanded="true" aria-controls="collapseArea">
                        <i class="fas fa-vector-square"></i>
                        <span>Tìm Theo Diện Tích</span>
                    </a>
                    <div id="collapseArea" class="collapse" aria-labelledby="headingArea"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByArea(0, 20)">Dưới 20m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(20, 25)">Từ 20m² đến 25m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(25, 30)">Từ 25m² đến 30m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(30, 35)">Từ 30m² đến 35m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(35, 40)">Từ 35m² đến 40m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(40)">Trên 40m²</a>
                        </div>
                    </div>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDistrict"
                        aria-expanded="true" aria-controls="collapseDistrict">
                        <i class="fas fa-fw fa-map-marker-alt"></i>
                        <span>Tìm Theo Quận</span>
                    </a>
                    <div id="collapseDistrict" class="collapse" aria-labelledby="headingDistrict"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hà Đông')">Hà Đông</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hoàn Kiếm')">Hoàn Kiếm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ba Đình')">Ba Đình</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Đống Đa')">Đống Đa</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hai Bà Trưng')">Hai Bà Trưng</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Cầu Giấy')">Cầu Giấy</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Tây Hồ')">Tây Hồ</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thanh Xuân')">Thanh Xuân</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Long Biên')">Long Biên</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Nam Từ Liêm')">Nam Từ Liêm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Bắc Từ Liêm')">Bắc Từ Liêm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Gia Lâm')">Gia Lâm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Sóc Sơn')">Sóc Sơn</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Đông Anh')">Đông Anh</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thanh Trì')">Thanh Trì</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hoài Đức')">Hoài Đức</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Mê Linh')">Mê Linh</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thạch Thất')">Thạch Thất</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ứng Hòa')">Ứng Hòa</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ba Vì')">Ba Vì</a>
                        </div>
                    </div>

                </li>
                <hr class="sidebar-divider">

                <!-- Advanced Search Button at the bottom -->
                <li class="nav-item">
                    <a class="nav-link" href="#" @click="toAdvancedSearchPage">
                        <i class="fas fa-search-plus"></i>
                        <span>Tìm Kiếm Nâng Cao</span>
                    </a>
                </li>


            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form
                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small"
                                    placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                    aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                placeholder="Search for..." aria-label="Search"
                                                aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <li class="nav-item mx-1 d-flex align-items-center" v-if="isAdmin">
                                <button type="button" class="btn btn-primary" @click="toAdminPage">
                                    <i class="fas fa-sync-alt fa-fw"></i>
                                    Trang Quản Trị
                                </button>
                            </li>
                            <li class="nav-item mx-1 d-flex align-items-center">
                                <button type="button" class="btn btn-primary" @click="addNewMotel">
                                    <i class="fas fa-plus fa-fw"></i>
                                    Thêm nhà trọ mới
                                </button>
                            </li>



                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow" v-if="hasToken">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{
                                        userInfo.fullName }}</span>

                                    <img class="img-profile rounded-circle"
                                        :src="this.avatar || '../../assets/img/undraw_profile.svg'">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" @click="toProfilePage">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Thông Tin Cá Nhân
                                    </a>
                                    <a class="dropdown-item" href="#" @click="toMyMotel">
                                        <i class="fas fa-building fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Nhà Trọ Đã Đăng
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" @click="openLogoutModal" style="cursor: pointer;">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-red-400"></i>
                                        Logout
                                    </a>

                                </div>
                            </li>
                            <button type="button" class="btn btn-sm" v-if="!hasToken" @click="LogoutUser">
                                <i class="bi bi-box-arrow-in-right"></i> Login
                            </button>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid py-4">
                        <!-- Page Heading với animation nhẹ -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800 border-bottom border-primary pb-2">
                                Trang Chủ
                            </h1>
                        </div>

                        <!-- Grid Layout cho danh sách phòng trọ -->
                        <div class="row g-4">
                            <div class="col-8" v-for="motel in listMotel" :key="motel.id">
                                <div class="card" @click="toMotelDetailPage(motel.id)" style="border: none; 
                   box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1); 
                   transition: all 0.3s ease;
                   cursor: pointer;
                   display: flex;
                   flex-direction: row;
                   border-radius: 12px;
                   overflow: hidden;
                   background: white;
                   height: 220px;">

                                    <!-- Phần hình ảnh bên trái -->
                                    <div style="position: relative; 
            width: 300px; 
            min-width: 300px; 
            height: 220px;"> <!-- Đặt chiều cao cố định -->
                                        <!-- Ảnh chính -->
                                        <img :src="motel.filesDTO && motel.filesDTO[0] ? motel.filesDTO[0].fileUrl : defaultImage"
                                            style="width: 100%; 
                height: 100%; 
                object-fit: contain;" alt="Motel Image">

                                        <!-- Badge VIP -->


                                        <!-- Số lượng ảnh -->
                                        <div style="position: absolute;
                           bottom: 10px;
                           right: 10px;
                           background: rgba(0, 0, 0, 0.6);
                           color: white;
                           padding: 4px 8px;
                           border-radius: 4px;
                           font-size: 12px;">
                                            <i class="fas fa-image"></i> {{ motel.filesDTO ? motel.filesDTO.length : 0
                                            }}
                                        </div>
                                    </div>

                                    <!-- Phần nội dung bên phải -->
                                    <div style="flex: 1;
                        padding: 16px;
                        display: flex;
                        flex-direction: column;">

                                        <!-- Tiêu đề -->
                                        <h5 style="font-size: 18px;
                          font-weight: 500;
                          margin-bottom: 12px;
                          line-height: 1.4;
                          color: #333;">
                                            {{ motel.title }}
                                        </h5>

                                        <!-- Giá và diện tích -->
                                        <div style="display: flex;
                           gap: 16px;
                           margin-bottom: 12px;">
                                            <div style="color: #f43f5e;
                               font-weight: 600;
                               font-size: 18px;">
                                                {{ formatPrice(motel.price) }} triệu/tháng
                                            </div>
                                            <div style="color: #666;
                               font-size: 16px;">
                                                {{ motel.area }}m²
                                            </div>
                                        </div>

                                        <!-- Địa chỉ -->
                                        <div style="display: flex;
                           align-items: center;
                           gap: 8px;
                           margin-bottom: 12px;">
                                            <i class="fas fa-map-marker-alt" style="color: #666;"></i>
                                            <span style="color: #666;">{{ motel.district }}</span>
                                        </div>

                                        <!-- Mô tả -->
                                        <p style="color: #666;
                         font-size: 14px;
                         line-height: 1.5;
                         margin-bottom: 12px;
                         display: -webkit-box;
                         -webkit-line-clamp: 2;
                         -webkit-box-orient: vertical;
                         overflow: hidden;">
                                            {{ motel.detail }}
                                        </p>

                                        <!-- Thời gian đăng -->
                                        <div
                                            style="margin-top: auto; font-size: 14px; color: #666; display: flex; align-items: center; gap: 16px;">
                                            <!-- Ngày đăng -->
                                            <div style="display: flex; align-items: center; gap: 8px;">
                                                <i class="fas fa-clock" style="color: #00b4d8;"></i>
                                                Ngày Đăng Bài: {{ formatDate(motel.createdAt) }}
                                            </div>
                                            <!-- Ngày chỉnh sửa -->
                                            <div style="display: flex; align-items: center; gap: 8px;">
                                                <i class="fas fa-edit" style="color: #f43f5e;"></i>
                                                Ngày Chỉnh Sửa: {{ formatDate(motel.updatedAt) }}
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Nút yêu thích -->
                                    <div style="position: absolute;
                       top: 10px;
                       right: 10px;
                       width: 32px;
                       height: 32px;
                       display: flex;
                       align-items: center;
                       justify-content: center;
                       border-radius: 50%;
                       background: white;
                       box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                       cursor: pointer;">
                                        <i class="far fa-heart" style="color: #666;"></i>
                                    </div>
                                </div>
                                <div style="border-bottom: 2px solid #ddd; margin: 16px 0;"></div>
                            </div>
                        </div>
                    </div>


                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->

                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal" tabindex="-1" v-if="showModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Đăng Xuất</h5>
                    </div>
                    <div class="modal-body">
                        <p>Bạn Có Muốn Đăng Xuất?</p>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                            @click=closeModal>Hủy</button>
                        <button type="button" class="btn btn-danger " data-bs-dismiss="modal" @click=LogoutUser>Đăng
                            Xuất</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</template>

<script>
import axios from 'axios';

export default {
    name: 'DashBoard',
    data() {
        return {
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/unnamed.png', import.meta.url).href,
            description: null,
            houseNumber: null,
            ward: null,
            district: null,
            province: null,
            areaFrom: null,
            areaTo: null,
            priceFrom: null,
            priceTo: null,
            interior: null,
            type: null,
            detailDescription: null,
            managerName: null,
            phoneNumber: null,
            page: null,
            maxPageItems: null,
            avatar: localStorage.getItem('avatar') || ''
        };
    },
    mounted() {
        if (this.hasToken) {
            if (!localStorage.getItem('userInfor')) {
                this.getUserInfo();
            } else {
                this.userInfo = JSON.parse(localStorage.getItem('userInfor'));
            }
        }
        if (localStorage.getItem('queryMotel')) {
            const queryMotel = JSON.parse(localStorage.getItem('queryMotel'));
            this.search(queryMotel);
            localStorage.removeItem('queryMotel');
        } else {
            this.getAllMotels();
        }
    },
    methods: {
        toMotelDetailPage(id) {
            this.$router.push({ name: 'MotelDetail', params: { id } });
        },
        toProfilePage() {
            this.$router.push('/profile')
        },
        LogoutUser() {
            this.showModal = false;
            this.clearDataAndRedirect('/login');
        },
        openLogoutModal() {
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false;
        },
        async getUserInfo() {
            const token = localStorage.getItem('token');
            if (token) {
                try {
                    const response = await axios.get('http://localhost:8081/get-infor', {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    });
                    localStorage.setItem('userInfor', JSON.stringify(response.data));
                    this.userInfo = response.data;
                    if (this.userInfo.fileUrl) {
                        localStorage.setItem('avatar', this.userInfo.fileUrl)
                        this.avatar = this.userInfo.fileUrl
                    }
                    console.log(response.data)
                } catch (error) {
                    console.error('Error fetching user info:', error);
                }
            }
        },
        async getAllMotels() {
            const response = await axios.get('http://localhost:8081/get-all-motels');
            console.log(response);
            this.listMotel = response.data;
        },
        async searchByPrice(priceFrom, priceTo) {
            const data = this.buildSearchData();
            data.priceFrom = priceFrom;
            data.priceTo = priceTo;
            this.search(data);
        },
        async searchByArea(areaFrom, areaTo) {
            const data = this.buildSearchData();
            data.areaFrom = areaFrom;
            data.areaTo = areaTo;
            this.search(data);
        },
        async searchByDistrict(district) {
            const data = this.buildSearchData();
            data.district = district;
            this.search(data);
        },
        async search(data) {
            console.log(data);
            const response = await axios.get('http://localhost:8081/search', {
                params: data,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log(response.data);
            this.listMotel = response.data;
        },
        buildSearchData() {
            return {
                description: this.description,
                houseNumber: this.houseNumber,
                ward: this.ward,
                district: this.district,
                province: this.province,
                areaFrom: this.areaFrom,
                areaTo: this.areaTo,
                priceFrom: this.priceFrom,
                priceTo: this.priceTo,
                interior: this.interior,
                type: this.type,
                detailDescription: this.detailDescription,
                managerName: this.managerName,
                phoneNumber: this.phoneNumber,
                page: this.page || 1,
                maxPageItems: this.maxPageItems || 10
            };
        },
        async toDashBoardPage() {
            this.$router.push('/').then(() => {
                window.location.reload();
            });
        },
        clearDataAndRedirect(route) {
            localStorage.clear();
            this.resetData();

            this.$router.push(route).then(() => {
                window.location.reload();
            });
        },
        toAdminPage() {
            this.$router.push('/admin')
        },
        toMyMotel() {
            this.$router.push('/my-motel')
        },
        toAdvancedSearchPage() {
            this.$router.push('/advanced-search')
        },
        resetData() {
            this.showModal = false;
            this.userInfo = {};
            this.listMotel = {};
            this.description = null;
            this.houseNumber = null;
            this.ward = null;
            this.district = null;
            this.province = null;
            this.areaFrom = null;
            this.areaTo = null;
            this.priceFrom = null;
            this.priceTo = null;
            this.interior = null;
            this.type = null;
            this.detailDescription = null;
            this.managerName = null;
            this.phoneNumber = null;
            this.page = null;
            this.maxPageItems = null;
        },
        addNewMotel() {
            if (this.hasToken) {
                this.$router.push('/add-motel')
            }
            else this.$router.push('/login')
        },
        formatPrice(price) {
            return new Intl.NumberFormat('vi-VN').format(price);
        },

        formatDate(date) {
            return new Date(date).toLocaleDateString('vi-VN');
        },

        getStatusBadgeClass(status) {
            switch (status) {
                case 'Đã Được Duyệt':
                case 'Đã Được Duyệt':
                    return 'bg-success';
                case 'Chưa Được Duyệt':
                case 'Chưa Được Duyệt':
                    return 'bg-danger';
                default:
                    return 'bg-secondary';
            }
        }
    },
    computed: {
        isAdmin() {
            return this.userInfo?.role === 'ADMIN';
        },
        hasToken() {
            return !!localStorage.getItem('token');
        }
    }
};
</script>
<style scoped></style>