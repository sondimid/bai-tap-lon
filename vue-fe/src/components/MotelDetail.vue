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


                    <div class="container-fluid " style="overflow: auto;" v-if="!openMotelUser">

                        <div class="row">
                            <div v-if="motel" class="col-md-8 motel-info">

                                <div v-if="isSelf" class="edit-container d-flex justify-content-end"
                                    style="margin-left: 16px;">
                                    <button class="btn btn-info d-flex align-items-center gap-2"
                                        @click="toEditMotel(motel.id)">
                                        <i class="fas fa-cog" style="margin-right: 10px;"></i>
                                        <span> Sửa Thông Tin Nhà Trọ</span>
                                    </button>
                                </div>

                                <div class="motel-image-container">
                                    <img :src="motel.filesDTO[currentImageIndex].fileUrl"
                                        @error="e => e.target.src = defaultImage" alt="Motel Image"
                                        class="motel-image-large" @load="handleImageLoad" v-show="!isLoading"
                                        style="width: 100%; height: 100%; object-fit: contain;" />
                                    <div class="image-navigation">
                                        <button @click="previousImage" class="nav-button prev">
                                            <span>←</span>
                                        </button>
                                        <button @click="nextImage" class="nav-button next">
                                            <span>→</span>
                                        </button>
                                    </div>
                                    <div class="image-counter">
                                        {{ currentImageIndex + 1 }} / {{ motel.filesDTO.length }}
                                    </div>
                                </div>
                                <div class="motel-details">
                                    <h2 class="motel-title">{{ motel.title }}</h2>
                                    <div style="display: flex; align-items: center; gap: 8px; margin-bottom: 12px;">
                                        <i class="fas fa-map-marker-alt" style="color: red;"></i>
                                        <span style="color: #666;">{{ motel.ward }} {{ motel.address }}</span>
                                    </div>
                                    <p style="color:green;"><strong>Giá:</strong> {{ motel.price }} triệu/tháng</p>
                                    <p style="color:black;"><strong>Diện tích:</strong> {{ motel.area }} m²</p>
                                    <p><strong>Số Người Ở Tối Đa:</strong> {{ motel.maxPeople }}</p>
                                    <p><strong>Loại hình:</strong> {{ motel.type }}</p>
                                    <p><strong>Chi tiết:</strong> {{ motel.detail }}</p>
                                    <p :style="{ color: motel.status === 'Đã Được Duyệt' ? 'green' : 'red' }">
                                        <strong>Trạng Thái:</strong> {{ motel.status }}
                                    </p>
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

                                    <!-- Nút chỉnh sửa nếu là chủ nhà -->

                                </div>

                            </div>
                            <div class="col-md-4 rental-info">
                                <div class="retal-info-header">Thông tin người cho thuê</div>
                                <img :src="motel.owner.fileUrl || defaultImage" alt="Renter Avatar"
                                    class="renter-avatar" />
                                <p><strong>Tên:</strong> {{ motel.owner.fullName }}</p>
                                <p><strong>Số điện thoại:</strong> {{ motel.owner.phoneNumber }}</p>
                                <div class="button-container">
                                    <button class="contact-button" style="margin-right: 15px;"
                                        @click="getMotelsByUser(motel.owner)">Xem Thêm Nhà Trọ
                                    </button>
                                    <button class="contact-button" v-if="!isSelf" @click="toggleChatBox">Chat</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" v-else>
                        <div class="col-8">
                            <div v-for="motel in listMotel" :key="motel.id">
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
         height: 220px;">
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
                                        <p><strong>{{ motel.type }}</strong></p>
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
                        <div class="col-4 rental-info">
                            <div class="retal-info-header">Thông tin người cho thuê</div>
                            <img :src="motel.owner.fileUrl || defaultImage" alt="Renter Avatar" class="renter-avatar" />
                            <p><strong>Tên:</strong> {{ motel.owner.fullName }}</p>
                            <p><strong>Số điện thoại:</strong> {{ motel.owner.phoneNumber }}</p>
                            <div class="button-container">

                                <button class="contact-button" v-if="!isSelf" @click="toggleChatBox">Chat</button>
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
        <div v-if="isChatBoxVisible" class="chat-box">
            <div class="chat-header">
                <h3>Chat với {{ motel.owner.fullName }}</h3>
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
                        <button type="button" class="btn btn-danger " data-bs-dismiss="modal" @click=toLoginPage>Đăng
                            Xuất</button>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="showSuccessModal" class="modal success-modal">
            <div class="modal-content">
                <h2>Thành công!</h2>
                <p>Bài đăng đã được xử lý thành công.</p>
                <button class="btn btn-primary" @click="closeModalSuccess">Đóng</button>
            </div>
        </div>

    </body>
</template>

<script>
import axios from 'axios';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';
export default {
    name: 'MotelDetail',
    data() {
        return {
            showModal: false,
            userInfo: {},
            motel: null,
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
            currentImageIndex: 0,
            avatar: localStorage.getItem('avatar') || '',
            motelUser: {},
            isLoading: false,
            namePage: null,
            openMotelUser: false,
            isChatBoxVisible: false,
            messages: [],
            messageContent: "",
            stompClient: null,
            senderId: null,
            recipientId: null,
            showSuccessModal: false,
        };
    },
    created() {
        const motelId = this.$route.params.id;
        if (motelId) {
            this.fetchMotelDetail(motelId);
        }

    },
    mounted() {

        if (this.hasToken) {
            if (!localStorage.getItem('userInfor')) {
                this.getUserInfo();
            } else {
                this.userInfo = JSON.parse(localStorage.getItem('userInfor'));
            }
        }
        const motelId = this.$route.params.id;
        if (motelId) {
            this.fetchMotelDetail(motelId);
        } else {
            console.error('Motel ID is missing');
        }
        this.fetchMessages();
        this.connect();
        if (this.isChatBoxVisible) {
            this.scrollToBottom();

        }

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

        }
    },
    methods: {
        toDashBoardPage() {
            this.resetData();
            this.$router.push('/').then(() => {
                window.location.reload();
            });
        },
        toLoginPage() {
            this.showModal = false;
            localStorage.clear();
            this.$router.push('/login')
        },
        openLogoutModal() {
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false
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
                    console.log(response);
                    this.userInfo = response.data;
                    this.senderId = this.userInfo.id
                } catch (error) {
                    console.error('Error fetching user info:', error);
                }
            }
            this.userInfo = localStorage.getItem('userInfor')

        },
        async getAllMotels() {
            this.listMotel = listMotel;
            console.log(this.listMotel);
        },
        async searchByPrice(priceFrom, priceTo) {
            const data = this.createSearchData({ priceFrom, priceTo });
            this.search(data);
        },
        async searchByArea(areaFrom, areaTo) {
            const data = this.createSearchData({ areaFrom, areaTo });
            this.search(data);
        },
        async searchByDistrict(district) {
            const data = this.createSearchData({ district });
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
        fetchMotelDetail(id) {
            axios.get(`http://localhost:8081/motel/${id}`)
                .then(response => {
                    this.motel = response.data;
                    console.log(this.motel);
                })
                .catch(error => {
                    console.error('Error fetching motel details:', error);
                });
        },
        async getMotelsByUser(user) {
            const token = localStorage.getItem('token');
            const response = await axios.get(`http://localhost:8081/get-motels-by-user/${user.id}`, {
                headers: {
                    'Authorization': `Bearer ${token}`,
                }
            })
            this.listMotel = response.data
            this.motelUser = user.data
            this.recipientId = user.id
            console.log(this.listMotel)
            this.namePage = "Xem Thêm Nhà Trọ";
            this.openMotelUser = true
            this.openList
        },
        createSearchData(overrides) {
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
                maxPageItems: this.maxPageItems || 10,
                ...overrides
            };
        },
        previousImage() {
            if (this.currentImageIndex > 0) {
                this.currentImageIndex--;
            } else {
                this.currentImageIndex = this.motel.filesDTO.length - 1;
            }
        },
        nextImage() {
            if (this.currentImageIndex < this.motel.filesDTO.length - 1) {
                this.currentImageIndex++;
            } else {
                this.currentImageIndex = 0;
            }
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
        formatDate(date) {
            return new Date(date).toLocaleDateString('vi-VN');
        },
        formatPrice(price) {
            return new Intl.NumberFormat('vi-VN').format(price);
        },
        toMotelDetailPage(id) {
            this.$router.push({ name: 'MotelDetail', params: { id } });
        },
        toggleChatBox() {
            this.isChatBoxVisible = !this.isChatBoxVisible;
            this.connect();
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
                    recipientId: this.motel.owner.id,
                    content: this.messageContent.trim(),
                    timestamp: new Date(),
                };
                this.stompClient.send("/app/message", {}, JSON.stringify(chatMessage));
                this.messages.push({ ...chatMessage });
                this.messageContent = "";
                this.scrollToBottom();

            }
        },
        async fetchMessages() {
            if (this.userInfo.id != this.motel.owner.id) {
                await axios.get(`http://localhost:8081/messages/${this.userInfo.id}/${this.motel.owner.id}`)
                    .then(response => {
                        this.messages = response.data;
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.error('Error fetching messages:', error);
                    });
            }
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

            // Chuyển đổi sang định dạng 12 giờ
            hours = hours % 12;
            hours = hours ? hours : 12; // Nếu hours = 0 thì đổi thành 12

            // Thêm số 0 phía trước nếu cần
            minutes = minutes < 10 ? '0' + minutes : minutes;

            return `${hours}:${minutes} ${ampm}`;
        },
        toProfilePage() {
            this.$router.push('/profile')
        },
        toMyMotel() {
            this.$router.push('/my-motel')
        },
        addNewMotel() {
            if (this.hasToken) {
                this.$router.push('/add-motel')
            }
            else this.$router.push('/login')
        },
        async markMotel() {
            const token = localStorage.getItem('token');
            const response = await axios.post(`http://localhost:8081/admin/markMotel`, null, {
                params: {
                    selectedMotels: this.selectedMotels.join(',')
                },
                headers: {
                    'Authorization': `Bearer ${token}`,
                }
            });

            this.showSuccessModal = true

        },
        closeModalSuccess() {
            this.showSuccessModal = false
            window.location.reload();
        },
        toEditMotel(id) {
            this.$router.push({ name: 'EditMotel', params: { id } });
        }
    },

    computed: {
        hasToken() {
            return !!localStorage.getItem('token')
        },
        isSelf() {
            console.log(this.userInfo.id + this.motel.owner.id)
            return this.userInfo.id === this.motel.owner.id;
        }
    },


}
</script>

<style>
.motel-image-container {
    position: relative;
    width: 100%;
    height: 500px;
    overflow: hidden;
    border-radius: 12px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
    background-color: #f8f9fa;
}

.motel-image-large {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.5s ease;
    display: block;
}

.motel-image-large:hover {
    transform: scale(1.02);
}

.image-navigation {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
    opacity: 0;
    transition: opacity 0.3s ease;
}

.motel-image-container:hover .image-navigation {
    opacity: 1;
}

.image-navigation button {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    background-color: rgba(255, 255, 255, 0.9);
    border: none;
    cursor: pointer;
    font-size: 24px;
    color: #333;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: all 0.3s ease;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    z-index: 2;
}

.image-navigation button:hover {
    background-color: white;
    transform: scale(1.1);
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

.image-navigation button:focus {
    outline: none;
}

.image-navigation button:active {
    transform: scale(0.95);
}

/* Image Counter */
.image-counter {
    position: absolute;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
    padding: 8px 15px;
    border-radius: 20px;
    font-size: 14px;
    z-index: 2;
}

/* Image Loading State */
.motel-image-container::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: #f8f9fa;
    z-index: 1;
    opacity: 0;
    transition: opacity 0.3s ease;
}

.motel-image-container.loading::before {
    opacity: 1;
}

/* Responsive Design */
@media (max-width: 768px) {
    .motel-image-container {
        height: 300px;
    }

    .image-navigation button {
        width: 40px;
        height: 40px;
        font-size: 20px;
    }
}

@media (max-width: 480px) {
    .motel-image-container {
        height: 250px;
        border-radius: 8px;
    }

    .image-navigation {
        padding: 0 10px;
    }

    .image-navigation button {
        width: 35px;
        height: 35px;
        font-size: 18px;
    }
}

/* Thông tin motel */
.motel-details {
    max-height: 250px;
    overflow-y: auto;
    padding: 20px;
    border: 2px solid #ddd;
    border-radius: 8px;
    background-color: #fafafa;
}

.motel-title {
    font-size: 28px;
    font-weight: bold;
    margin-bottom: 15px;
    color: #055699;
    text-transform: uppercase;
}

.motel-details p {
    font-size: 16px;
    margin-bottom: 12px;
    color: #555;
}

.motel-details p strong {
    color: #333;
}

.motel-details p span.price {
    color: #28a745;
    font-weight: bold;
}

.rental-info {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    border: 1px solid #ddd;
    /* Sử dụng flexbox để căn giữa nội dung */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
}

.retal-info-header {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 15px;
    text-align: center;
}

.renter-avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
    margin-bottom: 15px;
}

.rental-info p {
    text-align: center;
    margin-bottom: 10px;
}

.contact-button {
    background-color: #28a745;
    color: white;
    padding: 12px 25px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 20px;
    font-size: 16px;
}

.contact-button:hover {
    background-color: #218838;
}


.re__btn {
    font-size: 10px;
    padding: 3px 8px;
    border-radius: 5px;
    transition: all 0.3s ease;
    width: 80px;
    max-width: 100px;
    text-align: center;
    overflow: hidden;
    white-space: nowrap;
}

.re__btn-se-border--md {
    border: 2px solid #3498db;
    background-color: transparent;
}

.re__btn-se-ghost--md {
    color: #3498db;
    background-color: transparent;
}

.login-btn {
    font-weight: bold;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.re__btn:hover {
    background-color: #3498db;
    color: #ffffff;
    transform: scale(1.05);
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.15);
}

.re__btn:active {
    transform: scale(0.98);
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
}

.card {
    display: flex;
    border: 1px solid #dee2e6;
    border-radius: 0.5rem;
    overflow: hidden;
    margin-right: 10px;
}

.card-img-right {
    width: 30%;
    /* Reduced to 30% for a larger card body */
    height: auto;
}

.card-body {
    padding: 4.5rem;
    width: 70%;
}

.card-title {
    margin-bottom: 0.5rem;
}

.card-text {
    color: #6c757d;
}

.chat-box {
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 320px;
    height: 450px;
    background: white;
    border-radius: 12px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
    display: flex;
    flex-direction: column;
    overflow: hidden;
    font-family: Arial, sans-serif;
    border: 1px solid #e1e1e1;
}

.chat-header {
    padding: 15px;
    background: #2563eb;
    color: white;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #2563eb;
}

.chat-header h3 {
    margin: 0;
    font-size: 16px;
}

.close-button {
    background: none;
    border: none;
    color: white;
    font-size: 18px;
    cursor: pointer;
    padding: 5px 10px;
    border-radius: 5px;
    transition: background-color 0.2s;
}

.close-button:hover {
    background-color: rgba(255, 255, 255, 0.1);
}

.chat-messages {
    flex: 1;
    overflow-y: auto;
    padding: 15px;
    background: #f8fafc;
    display: flex;
    flex-direction: column;
    gap: 10px;
    scroll-behavior: auto;
    /* Smooth scrolling */
}

.message-sender {
    align-self: flex-end;
    max-width: 70%;
    padding: 10px 15px;
    border-radius: 15px 15px 0 15px;
    background-color: #2563eb;
    color: white;
    word-wrap: break-word;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
}

.message-receiver {
    align-self: flex-start;
    max-width: 70%;
    padding: 10px 15px;
    border-radius: 15px 15px 15px 0;
    background-color: #e2e8f0;
    color: black;
    word-wrap: break-word;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
}

.chat-input {
    padding: 15px;
    background: white;
    border-top: 1px solid #e1e1e1;
    display: flex;
    gap: 10px;
}

.chat-input input {
    flex: 1;
    padding: 10px;
    border: 1px solid #e1e1e1;
    border-radius: 20px;
    outline: none;
    font-size: 14px;
    transition: border-color 0.2s;
}

.chat-input input:hover {
    border-color: #2563eb;
}

.chat-input button {
    padding: 10px 20px;
    background: #2563eb;
    color: white;
    border: none;
    border-radius: 20px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.2s;
}

.chat-input button:hover {
    background-color: #1d4ed8;
}

.message-time {
    font-size: 0.75rem;
    color: #65676b;
    display: block;
    margin-top: 0.25rem;
}
</style>