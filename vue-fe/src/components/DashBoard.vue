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
                            <a class="collapse-item" href="#" @click="searchByPrice(1, 2)">Từ 1 triệu đến 2 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(2, 3)">Từ 2 triệu đến 3 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(3, 5)">Từ 3 triệu đến 5 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(5, 7)">Từ 5 triệu đến 7 triệu</a>
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

                <li class="nav-item">
                    <a class="nav-link" href="#" @click="toAdvancedSearchPage">
                        <i class="fas fa-search-plus"></i>
                        <span>Tìm Kiếm Nâng Cao</span>
                    </a>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link" href="#" @click="toFindByRadius">
                        <i class="fa-solid fa-magnifying-glass-location"></i>
                        <span>Tìm Kiếm Theo Bán Kính</span>
                    </a>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link" href="#" v-if="hasToken" @click="toFavoriteMotel">
                        <i class="fa-solid fa-hotel"></i>
                        <span>Nhà Trọ Đã Lưu</span>
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

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->

                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-envelope fa-fw"></i>
                                    <!-- Counter - Messages -->
                                    <span class="badge badge-danger badge-counter"></span>
                                    <!-- Biểu tượng tin nhắn mới -->
                                    <span v-if="hasNewMessages" class="badge badge-success badge-new">Mới</span>
                                </a>
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="messagesDropdown">
                                    <h6 class="dropdown-header">
                                        Tin Nhắn Mới
                                    </h6>
                                    <a v-for="user in listUser" :key="user.id"
                                        class="dropdown-item d-flex align-items-center" href="#"
                                        @click="toggleChatBox(user)">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle"
                                                :src="user.fileUrl || '../../assets/img/undraw_profile.svg'"
                                                alt="Avatar">
                                        </div>
                                        <div class="font-weight-bold w-100">
                                            <div class="d-flex justify-content-between">
                                                <div class="text-truncate">{{ user.fullName }}</div>
                                                <div class="small text-gray-500">{{ formatTime(user.timestamp) }}
                                                </div>
                                            </div>
                                            <div class="text-truncate small text-gray-700">{{ user.content }}
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </li>



                            <div class="topbar-divider d-none d-sm-block"></div>


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
                                <a class="nav-link dropdown-toggle" id="userDropdown" role="button"
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
                    <div class="col-12 mb-3 d-flex justify-content-start" v-if="selectedMotels.length && isAdmin">
                        <button class="btn btn-danger" @click="deleteMotels(1)">
                            Xóa Bài Đăng
                        </button>
                        <button class="btn btn-warning" style="margin-left: 20px;" @click="deleteMotels(0)">
                            Gỡ Bài Đăng
                        </button>
                    </div>


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
                   height: 240px;">
                                    <div style="position: absolute; 
                top: 10px; 
                left: 10px; 
                z-index: 10;">
                                        <input type="checkbox" :value="motel.id" v-model="selectedMotels" @click.stop
                                            style="width: 20px;  height: 18px;   cursor: pointer;" v-if="isAdmin">
                                    </div>


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
            margin-bottom: 12px; 
            align-items: center;">
                                            <div style="color: #f43f5e; 
                font-weight: 600; 
                font-size: 18px; 
                line-height: 1.2;">
                                                <i class="fa-solid fa-dollar-sign"></i>
                                                {{ formatPrice(motel.price) }} triệu/tháng
                                            </div>
                                            <div style="color: #666; 
                font-size: 16px; 
                line-height: 1.2;">
                                                {{ motel.area }}m²
                                            </div>
                                        </div>


                                        <!-- Địa chỉ -->
                                        <div style="display: flex;
                           align-items: center;
                           gap: 8px;
                           margin-bottom: 12px;">
                                            <i class="fas fa-map-marker-alt" style="color: red;"></i>
                                            <span style="color: #666;">{{ motel.ward }}, {{ motel.district }}</span>
                                        </div>

                                        <p><strong>{{ motel.type }}</strong> </p>

                                        <!-- Mô tả -->
                                        <p style="color: #666;
                         font-size: 20px;
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
                                    <div id="favorite-button" v-if="hasToken" @click.stop="toggleFavorite(motel.id)"
                                        style="position: absolute;
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
                                        <i :class="isFavorite(motel.id) ? 'fas fa-heart red-heart' : 'far fa-heart'"
                                            style="transition: color 0.3s;"></i>
                                    </div>


                                </div>
                                <div style="border-bottom: 2px solid #ddd; margin: 16px 0;"></div>
                            </div>
                        </div>
                        <nav>
                            <ul class="pagination">
                                <li class="page-item" :class="{ disabled: this.currentPage === 1 }"
                                    @click="changePage(this.currentPage - 1)">
                                    <a class="page-link">Previous</a>
                                </li>
                                <li class="page-item" :class="{ active: page === this.currentPage }"
                                    v-for="page in totalPages" :key="page" @click="changePage(page)">
                                    <a class="page-link">{{ page }}</a>
                                </li>
                                <li class="page-item" :class="{ disabled: this.currentPage === this.totalPages }"
                                    @click="changePage(this.currentPage + 1)">
                                    <a class="page-link">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>


                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <div v-if="isChatBoxVisible" class="chat-box">
            <div class="chat-header">
                <h3>Chat với {{ nameChat }}</h3>
                <button class="close-button" @click="closeToggleChatBox">×</button>
            </div>

            <div class="chat-messages" ref="chatMessagesContainer">
                <div v-for="(message, index) in messages" :key="index" :class="{
                    'message-sender': message.senderId === this.userInfo.id,
                    'message-receiver': message.senderId !== this.userInfo.id
                }">
                    <p>{{ message.content }}</p>
                    <span class="message-time">{{ formatTime(message.timestamp) }}</span>
                </div>
            </div>

            <div class="chat-input">
                <input type="text" v-model="messageContent" @keyup.enter="sendMessage" placeholder="Nhập tin nhắn..." />
                <button @click="sendMessage">Gửi</button>
            </div>
        </div>

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

        <div v-if="showMoalDelete" class="modal success-modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Thông Báo</h5>
                    </div>
                    <div class="modal-body">
                        <p>{{ messageDelete }}</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal"
                            @click=closeModalDelete>OK</button>
                    </div>
                </div>
            </div>
        </div>


    </body>
</template>

<script>
import axios from 'axios';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';
export default {
    name: 'DashBoard',
    data() {
        return {
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/undraw_profile.svg', import.meta.url).href,
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
            avatar: localStorage.getItem('avatar') || this.defaultImage,
            listUser: {},
            hasNewMessages: false,
            isChatBoxVisible: false,
            messages: [],
            messageContent: "",
            stompClient: null,
            senderId: null,
            recipientId: null,
            nameChat: null,
            selectedMotels: [],
            showMoalDelete: false,
            messageDelete: null,
            currentPage: 1, 
            pageSize: null, 
            totalPages: null, 
            isAdvanceSearch: false,
            formSearch: null,
            favorites: [],
        };
    },
    mounted() {
        
        if (this.hasToken) {
            if (!localStorage.getItem('userInfor')) {
                this.getUserInfo();
                
            } else {
                this.userInfo = JSON.parse(localStorage.getItem('userInfor'));
            }
            this.fetchFavorites()
            
        }
       
        this.getAllMotels();
        
        this.fetchUers();
        this.connect();
        if (this.isChatBoxVisible) {
            this.scrollToBottom();
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
            this.isAdvanceSearch = false
            const response = await axios.get('http://localhost:8081/get-all-motels', {
                params: {
                    currentPage: this.currentPage
                }
            });
            console.log(response);
            this.listMotel = response.data.content;
            if (this.totalPages == null) {
                this.totalPages = response.data.totalPages
            }
            this.pageSize = response.data.pageSize
        },
        async searchByPrice(priceFrom, priceTo) {
            this.formSearch= this.buildSearchData();
            this.formSearch.priceFrom = priceFrom;
            this.formSearch.priceTo = priceTo;
            this.search();
        },
        async searchByArea(areaFrom, areaTo) {
            this.formSearch= this.buildSearchData();
            this.formSearch.areaFrom = areaFrom;
            this.formSearch.areaTo = areaTo;
            this.search();
        },
        async searchByDistrict(district) {
            this.formSearch= this.buildSearchData();
            this.formSearch.district = district;
            this.search();
        },
        async search() {
            this.isAdvanceSearch = true
            this.formSearch.page = this.currentPage
            const response = await axios.get('http://localhost:8081/search', {
                params: this.formSearch,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            this.listMotel = response.data.content;
            if (this.totalPages == null) {
                this.totalPages = response.data.totalPages
            }
            this.pageSize = response.data.pageSize
        },
        buildSearchData() {
            this.totalPages = null
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
                page: this.currentPage,
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
            this.listUser = {};
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
        async fetchUers() {
            const response = await axios.get('http://localhost:8081/get-all-ids', {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                }
            });
            this.listUser = response.data
            console.log(this.listUser)
        },
        toggleChatBox(user) {
            this.recipientId = user.id
            this.connect();
            this.nameChat = user.fullName
            this.fetchMessages(user.id)
            this.isChatBoxVisible = !this.isChatBoxVisible;

        },
        connect() {
            if (this.stompClient && this.stompClient.connected) {
                console.log("Already connected");
                return;
            }
            const socket = new SockJS("http://localhost:8081/chat");
            this.stompClient = Stomp.over(socket);
            this.stompClient.connect({}, () => {
                console.log("Connected");
                this.stompClient.subscribe(`/user/${this.userInfo.id}/queue/messages`, (message) => {
                    const receivedMessage = JSON.parse(message.body);
                    this.messages.push(receivedMessage);
                });
            });
        },
        closeToggleChatBox() {
            this.isChatBoxVisible = false;
            this.disconnect();
        },
        disconnect() {
            if (this.stompClient) {
                this.stompClient.disconnect();
                console.log("Disconnected");
            }
        },
        sendMessage() {
            if (this.messageContent.trim() && this.stompClient) {
                const chatMessage = {
                    senderId: this.userInfo.id,
                    recipientId: this.recipientId,
                    content: this.messageContent.trim(),
                    timestamp: new Date(),
                };
                this.stompClient.send("/app/message", {}, JSON.stringify(chatMessage));
                this.messages.push({ ...chatMessage });
                this.messageContent = "";
                this.scrollToBottom();

            }
        },
        async fetchMessages(id) {
            await axios.get(`http://localhost:8081/messages/${this.userInfo.id}/${id}`)
                .then(response => {
                    this.messages = response.data;
                    console.log(response.data);
                })
                .catch(error => {
                    console.error('Error fetching messages:', error);
                });
        },
        scrollToBottom() {
            this.$nextTick(() => {
                if (this.$refs.chatMessagesContainer) {
                    this.$refs.chatMessagesContainer.scrollTop = this.$refs.chatMessagesContainer.scrollHeight;
                }
            });
        },
        formatTime(timestamp) {
            const date = new Date(timestamp);
            let hours = date.getHours();
            let minutes = date.getMinutes();
            const ampm = hours >= 12 ? 'PM' : 'AM';

            hours = hours % 12;
            hours = hours ? hours : 12; 

            minutes = minutes < 10 ? '0' + minutes : minutes;

            return `${hours}:${minutes} ${ampm}`;
        },
        async deleteMotels(value) {
            console.log(this.selectedMotels)
            const token = localStorage.getItem('token');

            const response = await axios.delete(`http://localhost:8081/admin/delete-motels`, {
                params: {
                    selectedMotels: this.selectedMotels.join(','),
                    isDelete: value
                },
                headers: {
                    'Authorization': `Bearer ${token}`,
                }
            });
            this.messageDelete = response.data
            this.showMoalDelete = true
        },
        closeModalDelete() {
            this.showMoalDelete = false
            window.location.reload();
        },
        toFindByRadius() {
            this.$router.push('/find-by-radius')
        },
        changePage(page) {
            if (page > 0 && page <= this.totalPages) {
                this.currentPage = page
                if (this.isAdvanceSearch) {
                    this.search()
                }
                else this.getAllMotels()
            }
        },
        toggleFavorite(motelId) {
            if (this.favorites.includes(motelId)) {
                this.favorites = this.favorites.filter(id => id !== motelId);
            } else {
                this.favorites.push(motelId);
            }
            const response =  axios.post('http://localhost:8081/favorites', null, {
                params: {
                    ids: this.favorites.join(','),
                },
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                }
            });
        },
        isFavorite(motelId) {
            return this.favorites.includes(motelId);
        },
        async fetchFavorites() {
            const response = await axios.get('http://localhost:8081/get-favorites', {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                }
            })
            this.favorites = response.data.map(motel => motel.id);
            console.log(this.favorites)
        },
        toFavoriteMotel(){
            this.$router.push('/favorite-motel')
        }
    },
    computed: {
        isAdmin() {
            return this.userInfo?.role === 'ADMIN';
        },
        hasToken() {
            return !!localStorage.getItem('token');
        },
    },
    watch: {
        isChatBoxVisible(newVal) {
            if (newVal) {
                this.scrollToBottom();
            }
        },
        messages: {
            handler() {
                this.scrollToBottom();
            },

        },
    },
};
</script>
<style scoped>
.collapse-inner {
    max-height: 300px;
    overflow-y: auto;
}

.collapse-inner::-webkit-scrollbar {
    width: 6px;
}

.collapse-inner::-webkit-scrollbar-track {
    background: #f1f1f1;
    border-radius: 3px;
}

.collapse-inner::-webkit-scrollbar-thumb {
    background: #888;
    border-radius: 3px;
}

.collapse-inner::-webkit-scrollbar-thumb:hover {
    background: #555;
}
.pagination {
    display: flex;
    justify-content: center;
    list-style: none;
    padding: 0;
}

.page-item {
    margin: 0 5px;
    cursor: pointer;
}

.page-item.disabled {
    pointer-events: none;
    opacity: 0.5;
}

.page-item.active {
    font-weight: bold;
    color: #fff;
    background-color: #007bff;
    border-radius: 5px;
}

.red-heart {
    color: red;
}
</style>