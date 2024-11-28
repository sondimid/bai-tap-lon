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
                            <i class="fa fa-bars">
                            </i>
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
                    <form class="container-fluid" @submit.prevent="addMotel">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">
                                Sửa Thông Tin Nhà Trọ
                            </h1>
                        </div>
                        <fieldset class="border p-3">

                            <!-- Tên toà nhà -->
                            <div class="mb-3 row">
                                <label for="buildingName" class="col-3 col-form-label">Tên Nhà Trọ</label>
                                <div class="col-7">
                                    <input type="text" class="form-control" id="buildingName" v-model="title"
                                        placeholder="Nhập Tên Nhà Trọ" required />
                                </div>
                            </div>

                            <!-- Số nhà -->

                            <!-- Diện tích từ - đến -->
                            <div class="mb-3 row">
                                <label class="col-3 col-form-label">Diện tích (m²)</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="area" v-model="area"
                                        placeholder="Diện tích " required />
                                </div>

                            </div>

                            <!-- Giá thuê từ - đến -->
                            <div class="mb-3 row">
                                <label class="col-3 col-form-label">Giá thuê (Triệu VND /Tháng)</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="price" v-model="price"
                                        placeholder="Giá thuê" required />
                                </div>

                            </div>

                            <!-- Nội thất -->
                            <div class="mb-3 row">
                                <label for="maxPeople" class="col-3 col-form-label">Số Người Ở Tối Đa</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="maxPeople" v-model="maxPeople"
                                        placeholder="Số người ở tối đa" required />
                                </div>
                            </div>

                            <!-- Loại hình -->
                            <div class="mb-3 row">
                                <label for="type" class="col-3 col-form-label">Loại hình</label>
                                <div class="col-7">
                                    <input type="text" class="form-control" id="type" v-model="type"
                                        placeholder="Loại hình" required />
                                </div>
                            </div>

                            <!-- Mô tả chi tiết -->
                            <div class="mb-3 row">
                                <label for="detail" class="col-3 col-form-label">Mô tả chi
                                    tiết</label>
                                <div class="col-7">
                                    <textarea class="form-control" id="detail" v-model="detail"
                                        placeholder="Mô tả chi tiết" required></textarea>
                                </div>
                            </div>

                            <div class="mb-3 row">
                                <label for="uploadFile" class="col-3 col-form-label">Hình ảnh đã lưu</label>
                                <div class="col-7">
                                    <!-- Preview container -->
                                    <div class="mt-3 d-flex flex-wrap gap-3">
                                        <div v-for="(preview, index) in currents" :key="index"
                                            class="position-relative preview-container" style="width: 150px;">
                                            <img :src="preview.fileUrl" :alt="'Preview ' + (index + 1)"
                                                class="img-fluid rounded"
                                                style="height: 150px; object-fit: cover; width: 100%;" />
                                            <button @click="handleDeleteImg(preview.id)"
                                                class="btn btn-danger btn-sm delete-btn" type="button">
                                                <i class="fas fa-times"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3 row">
                                <label for="uploadFile" class="col-3 col-form-label">Thêm ảnh</label>
                                <div class="col-7">
                                    <input class="form-control mb-3" type="file" id="formFileMultiple" multiple
                                        @change="handleFileSelect" ref="fileInput" />

                                    <!-- Preview container -->
                                    <div class="mt-3 d-flex flex-wrap gap-3">
                                        <div v-for="(preview, index) in previews" :key="index"
                                            class="position-relative preview-container" style="width: 150px;">
                                            <img :src="preview.url" :alt="'Preview ' + (index + 1)"
                                                class="img-fluid rounded"
                                                style="height: 150px; object-fit: cover; width: 100%;" />
                                            <button @click="handleDelete(index)"
                                                class="btn btn-danger btn-sm delete-btn" type="button">
                                                <i class="fas fa-times"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Nút Tìm kiếm -->
                            <div class="mb-3 row">
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-primary w-50" style="font-size: 1.25rem;">
                                        Sửa Thông Tin
                                    </button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                    <!-- Begin Page Content -->


                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->

                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->


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

        <div class="modal" tabindex="-1" v-if="showModalSuccess">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">{{ modalTitle }}</h5>
                    </div>
                    <div class="modal-body">
                        <p>{{ modelMsg }}</p>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-primary " data-bs-dismiss="modal"
                            @click="closeModalSuccess">Ok</button>
                    </div>
                </div>
            </div>
        </div>

        <div v-if="isLoading" class="loading-overlay">
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>

    </body>
</template>

<script>
import axios from 'axios';

export default {
    name: 'EditMotel',
    data() {
        return {
            showModalSuccess: false,
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/undraw_profile.svg', import.meta.url).href,
            title: null,
            houseNumber: null,
            ward: null,
            district: null,
            province: null,
            areaFrom: null,
            areaTo: null,
            priceFrom: null,
            priceTo: null,
            interior: null,
            maxPeople: null,
            detail: null,
            managerName: null,
            phoneNumber: null,
            page: null,
            street: null,
            maxPageItems: null,
            avatar: localStorage.getItem('avatar') || '',
            area: null,
            price: null,
            modalTitle: null,
            modelMsg: null,
            isLoading: false,
            previews: [],
            currents: [],
            listFileId: [],
            motelEdit: null,
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
        else this.$router.push('/')
        this.fetchMotelEdit(this.$route.params.id)
        // this.getDistrict()
        
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
        async searchAdvance() {
            const data = this.buildSearchData();
            console.log(data)
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
                title: this.title,
                houseNumber: this.houseNumber,
                ward: this.ward,
                district: this.district,
                province: this.province,
                areaFrom: this.areaFrom,
                areaTo: this.areaTo,
                priceFrom: this.priceFrom,
                priceTo: this.priceTo,
                interior: this.interior,
                max: this.maxPeople,
                detail: this.detail,
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
        resetData() {
            this.showModal = false;
            this.userInfo = {};
            this.listMotel = {};
            this.title = null;
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
            this.detail = null;
            this.managerName = null;
            this.phoneNumber = null;
            this.page = null;
            this.maxPageItems = null;
        },
        closeModalSuccess() {
            this.showModalSuccess = false;
            window.location.href = '/my-motel';
        },
        async addMotel() {
            this.isLoading = true;
            const formData = new FormData();
            formData.append('id', this.$route.params.id)
            formData.append('title', this.title);
            formData.append('area', this.area);
            formData.append('price', this.price);
            formData.append('type', this.type);
            formData.append('maxPeople', this.maxPeople);
            formData.append('detail', this.detail);
            this.listFileId.forEach(id => {
                formData.append('listFileId[]', id); 
            });

            const fileImg = document.getElementById('formFileMultiple').files;
            for (let i = 0; i < fileImg.length; i++) {
                formData.append('files', fileImg[i]);
            }
            for (let [key, value] of formData.entries()) {
                console.log(`${key}: ${value}`);
            }
            const response = await axios.post('http://localhost:8081/create', formData, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                    'Content-Type': 'form-data',
                }
            });
            if (response.status === 201) {
                this.modalTitle = "Thành Công"
            }
            else {
                this.modalTitle = "Thất Bại"
            }
            this.modelMsg = "Sửa Thành Công"
            this.showModalSuccess = true
            this.isLoading = false
        },
        getDistrict() {
            const districts = [
                { id: 'district1', name: 'Ba Đình' },
                { id: 'district2', name: 'Hoàn Kiếm' },
                { id: 'district3', name: 'Tây Hồ' },
                { id: 'district4', name: 'Long Biên' },
                { id: 'district5', name: 'Cầu Giấy' },
                { id: 'district6', name: 'Đống Đa' },
                { id: 'district7', name: 'Hai Bà Trưng' },
                { id: 'district8', name: 'Hoàng Mai' },
                { id: 'district9', name: 'Nam Từ Liêm' },
                { id: 'district10', name: 'Bắc Từ Liêm' },
                { id: 'district11', name: 'Đông Anh' },
                { id: 'district12', name: 'Hà Đông' },
                { id: 'district13', name: 'Sóc Sơn' },
                { id: 'district14', name: 'Chương Mỹ' },
                { id: 'district15', name: 'Thanh Xuân' },
                { id: 'district16', name: 'Gia Lâm' },
                { id: 'district17', name: 'Thanh Trì' },
                { id: 'district18', name: 'Thường Tín' },
                { id: 'district19', name: 'Hoài Đức' },
                { id: 'district20', name: 'Mê Linh' },
                { id: 'district21', name: 'Phú Xuyên' },
                { id: 'district22', name: 'Thanh Oai' },
                { id: 'district23', name: 'Thạch Thất' },
                { id: 'district24', name: 'Ứng Hòa' },
                { id: 'district25', name: 'Mỹ Đức' },
                { id: 'district26', name: 'Quốc Oai' },
                { id: 'district27', name: 'Phúc Thọ' },
                { id: 'district28', name: 'Đan Phượng' },
                { id: 'district29', name: 'Sơn Tây' }

            ];

            const wards = {
                district1: [
                    'Cống Vị', 'Điện Biên', 'Đội Cấn', 'Giảng Võ', 'Kim Mã',
                    'Liễu Giai', 'Ngọc Hà', 'Ngọc Khánh', 'Nguyễn Trung Trực',
                    'Phúc Xá', 'Quán Thánh', 'Thành Công', 'Trúc Bạch', 'Vĩnh Phúc'
                ],
                district2: [
                    ' Chương Dương', ' Cửa Đông', ' Cửa Nam', ' Đồng Xuân', ' Hàng Bạc',
                    'Hàng Bài', 'Hàng Bồ', 'Hàng Bông', 'Hàng Buồm', 'Hàng Đào',
                    'Hàng Gai', 'Hàng Mã', 'Hàng Trống', 'Lý Thái Tổ', 'Phan Chu Trinh',
                    'Phúc Tân', 'Trần Hưng Đạo', 'Tràng Tiền'
                ],
                district3: [
                    'Bưởi', 'Nhật Tân', 'Phú Thượng', 'Quảng An',
                    'Thụy Khuê', 'Tứ Liên', 'Xuân La', 'Yên Phụ'
                ],
                district4: [
                    'Bồ Đề', 'Cự Khối', 'Đức Giang', 'Gia Thụy',
                    'Giang Biên', 'Long Biên', 'Ngọc Lâm', 'Ngọc Thụy',
                    'Phúc Đồng', 'Phúc Lợi', 'Sài Đồng', 'Thạch Bàn',
                    'Thượng Thanh', 'Việt Hưng'
                ],
                district5: [
                    'Dịch Vọng', 'Dịch Vọng Hậu', 'Mai Dịch', 'Nghĩa Đô',
                    'Nghĩa Tân', 'Quan Hoa', 'Trung Hòa', 'Yên Hòa'
                ],
                district6: [
                    'Cát Linh', 'Hàng Bột', 'Khâm Thiên', 'Khương Thượng', 'Kim Liên',
                    'Láng Hạ', 'Láng Thượng', 'Nam Đồng', 'Ngã Tư Sở', 'Ô Chợ Dừa',
                    'Phương Liên', 'Phương Mai', 'Quang Trung', 'Quốc Tử Giám', 'Thịnh Quan',
                    'Thổ Quan', 'Trung Liệt', 'Trung Phụng', 'Trung Tự', 'Văn Chương',
                    'Văn Miếu'
                ],
                district7: [
                    'Bách Khoa', 'Bạch Đằng', 'Bạch Mai', 'Cầu Dền', 'Đống Mác',
                    'Đồng Nhân', 'Đồng Tâm', 'Lê Đại Hành', 'Minh Khai', 'Nguyễn Du',
                    'Phạm Đình Hổ', 'Phố Huế', 'Quỳnh Lôi', 'Quỳnh Mai', 'Thanh Lương',
                    'Thanh Nhàn', 'Trương Định', 'Vĩnh Tuy'
                ],
                district8: [
                    'Đại Kim', 'Định Công', 'Giáp Bát', 'Hoàng Liệt', 'Hoàng Văn Thụ',
                    'Lĩnh Nam', 'Mai Động', 'Tân Mai', 'Thanh Trì', 'Thịnh Liệt',
                    'Trần Phú', 'Tương Mai', 'Vĩnh Hưng', 'Yên Sở'
                ],
                district9: [
                    'Cầu Diễn', 'Mỹ Đình 1', 'Mỹ Đình 2', 'Phú Đô', 'Mễ Trì',
                    'Trung Văn', 'Đại Mỗ', 'Tây Mỗ', 'Phương Canh', 'Xuân Phương'
                ],
                district10: [
                    'Cổ Nhuế 1', 'Cổ Nhuế 2', 'Đức Thắng', 'Đông Ngạc',
                    'Thụy Phương', 'Liên Mạc', 'Thượng Cát', 'Tây Tựu',
                    'Minh Khai', 'Phú Diễn', 'Phúc Diễn', 'Xuân Đỉnh', 'Xuân Tảo'
                ],
                district11: [
                    'Thị trấn Đông Anh', 'Xã Bắc Hồng', 'Xã Cổ Loa', 'Xã Đại Mạch', 'Xã Đông Hội',
                    'Xã Dục Tú', 'Xã Hải Bối', 'Xã Kim Chung', 'Xã Kim Nỗ', 'Xã Liên Hà',
                    'Xã Mai Lâm', 'Xã Nam Hồng', 'Xã Nguyên Khê', 'Xã Tàm Xá', 'Xã Thụy Lâm',
                    'Xã Tiên Dương', 'Xã Uy Nỗ', 'Xã Vân Hà', 'Xã Vân Nội', 'Xã Việt Hùng',
                    'Xã Vĩnh Ngọc', 'Xã Võng La', 'Xã Xuân Canh', 'Xã Xuân Nộn'
                ],
                district12: [
                    'Biên Giang', 'Đồng Mai', 'Yên Nghĩa', 'Dương Nội', 'Hà Cầu',
                    'La Khê', 'Mộ Lao', 'Nguyễn Trãi', 'Phú La', 'Phú Lãm',
                    'Phú Lương', 'Kiến Hưng', 'Phúc La', 'Quang Trung', 'Vạn Phúc',
                    'Văn Quán', 'Yết Kiêu'
                ],
                district13: [
                    'Thị trấn Sóc Sơn', 'Xã Bắc Phú', 'Xã Bắc Sơn', 'Xã Đông Xuân', 'Xã Đức Hòa', 'Xã Hiền Ninh',
                    'Xã Hồng Kỳ', 'Xã Kim Lũ', 'Xã Mai Đình', 'Xã Minh Phú', 'Xã Minh Trí', 'Xã Nam Sơn',
                    'Xã Phú Cường', 'Xã Phù Linh', 'Xã Phù Lỗ', 'Xã Phú Minh', 'Xã Quang Tiến', 'Xã Tân Dân',
                    'Xã Tân Hưng', 'Xã Tân Minh', 'Xã Thanh Xuân', 'Xã Tiên Dược', 'Xã Trung Giã', 'Xã Việt Long',
                    'Xã Xuân Giang', 'Xã Xuân Thu'
                ],
                district14: [
                    'Thị trấn Chúc Sơn', 'Thị trấn Xuân Mai', 'Xã Đại Yên', 'Xã Đông Phương Yên', 'Xã Đông Sơn',
                    'Xã Đồng Lạc', 'Xã Đồng Phú', 'Xã Hòa Chính', 'Xã Hoàng Diệu', 'Xã Hoàng Văn Thụ', 'Xã Hồng Phong',
                    'Xã Hợp Đồng', 'Xã Hữu Văn', 'Xã Lam Điền', 'Xã Mỹ Lương', 'Xã Nam Phương Tiến', 'Xã Ngọc Hòa',
                    'Xã Phú Nam An', 'Xã Phú Nghĩa', 'Xã Phụng Châu', 'Xã Quảng Bị', 'Xã Tân Tiến', 'Xã Tiên Phương',
                    'Xã Tốt Động', 'Xã Thanh Bình', 'Xã Thủy Xuân Tiên', 'Xã Thụy Hương', 'Xã Thượng Vực', 'Xã Trần Phú',
                    'Xã Trung Hòa', 'Xã Trường Yên', 'Xã Văn Võ'
                ],
                district15: [
                    'Hạ Đình', 'Khương Đình', 'Khương Mai', 'Khương Trung', 'Kim Giang',
                    'Nhân Chính', 'Phương Liệt', 'Thanh Xuân Bắc', 'Thanh Xuân Nam',
                    'Thanh Xuân Trung', 'Thượng Đình'
                ],
                district16: [
                    'Thị trấn Trâu Quỳ', 'Thị trấn Yên Viên', 'Xã Cổ Bi', 'Xã Đặng Xá', 'Xã Dương Xá',
                    'Xã Phú Thị', 'Xã Dương Quang', 'Xã Kim Sơn', 'Xã Lệ Chi', 'Xã Đông Dư',
                    'Xã Bát Tràng', 'Xã Kim Lan', 'Xã Văn Đức', 'Xã Đa Tốn', 'Xã Kiêu Kỵ',
                    'Xã Yên Thường', 'Xã Yên Viên', 'Xã Dương Hà', 'Xã Ninh Hiệp', 'Xã Đình Xuyên',
                    'Xã Phù Đổng', 'Xã Trung Mầu'
                ],
                district17: [
                    'Thị trấn Văn Điển', 'Xã Đại Áng', 'Xã Đông Mỹ', 'Xã Duyên Hà', 'Xã Hữu Hòa',
                    'Xã Liên Ninh', 'Xã Ngọc Hồi', 'Xã Ngũ Hiệp', 'Xã Tả Thanh Oai', 'Xã Tam Hiệp',
                    'Xã Tân Triều', 'Xã Thanh Liệt', 'Xã Tứ Hiệp', 'Xã Vạn Phúc', 'Xã Vĩnh Quỳnh',
                    'Xã Yên Mỹ'
                ],
                district18: [
                    'Thị trấn Thường Tín', 'Xã Chương Dương', 'Xã Dũng Tiến', 'Xã Duyên Thái', 'Xã Hà Hồi',
                    'Xã Hiền Giang', 'Xã Hòa Bình', 'Xã Khánh Hà', 'Xã Hồng Vân', 'Xã Lê Lợi',
                    'Xã Liên Phương', 'Xã Minh Cường', 'Xã Nghiêm Xuyên', 'Xã Nguyễn Trãi', 'Xã Nhị Khê',
                    'Xã Ninh Sở', 'Xã Quất Động', 'Xã Tân Minh', 'Xã Thắng Lợi', 'Xã Thống Nhất',
                    'Xã Thư Phú', 'Xã Tiền Phong', 'Xã Tô Hiệu', 'Xã Tự Nhiên', 'Xã Vạn Điểm',
                    'Xã Văn Bình', 'Xã Văn Phú', 'Xã Văn Tự', 'Xã Vân Tảo'
                ],
                district19: [
                    'Thị trấn Trạm Trôi', 'Xã An Khánh', 'Xã An Thượng', 'Xã Cát Quế', 'Xã Đắc Sở',
                    'Xã Di Trạch', 'Xã Đông La', 'Xã Đức Giang', 'Xã Đức Thượng', 'Xã Dương Liễu',
                    'Xã Kim Chung', 'Xã La Phù', 'Xã Lại Yên', 'Xã Minh Khai', 'Xã Sơn Đồng',
                    'Xã Song Phương', 'Xã Tiền Yên', 'Xã Vân Canh', 'Xã Vân Côn', 'Xã Yên Sở'
                ],
                district20: [
                    'Thị trấn Chi Đông', 'Thị trấn Quang Minh', 'Xã Chu Phan', 'Xã Đại Thịnh',
                    'Xã Hoàng Kim', 'Xã Kim Hoa', 'Xã Liên Mạc', 'Xã Mê Linh', 'Xã Tam Đồng',
                    'Xã Thạch Đà', 'Xã Thanh Lâm', 'Xã Tiền Phong', 'Xã Tiến Thắng', 'Xã Tiến Thịnh',
                    'Xã Tráng Việt', 'Xã Tự Lập', 'Xã Vạn Yên', 'Xã Văn Khê'
                ],
                district21: [
                    'Thị trấn Phú Xuyên', 'Thị trấn Phú Minh', 'Xã Bạch Hạ', 'Xã Châu Can',
                    'Xã Chuyên Mỹ', 'Xã Đại Thắng', 'Xã Đại Xuyên', 'Xã Hoàng Long', 'Xã Hồng Minh',
                    'Xã Hồng Thái', 'Xã Khai Thái', 'Xã Minh Tân', 'Xã Nam Phong', 'Xã Nam Tiến',
                    'Xã Nam Triều', 'Xã Phú Túc', 'Xã Phú Yên', 'Xã Phúc Tiến', 'Xã Phượng Dực',
                    'Xã Quang Lãng', 'Xã Quang Trung', 'Xã Sơn Hà', 'Xã Tân Dân', 'Xã Tri Thủy',
                    'Xã Tri Trung', 'Xã Văn Hoàng', 'Xã Vân Từ'
                ],
                district22: [
                    'Thị trấn Kim Bài', 'Xã Bích Hòa', 'Xã Bình Minh', 'Xã Cao Dương', 'Xã Cao Viên',
                    'Xã Cự Khê', 'Xã Dân Hòa', 'Xã Đỗ Động', 'Xã Hồng Dương', 'Xã Kim An',
                    'Xã Kim Thư', 'Xã Liên Châu', 'Xã Mỹ Hưng', 'Xã Phương Trung', 'Xã Tam Hưng',
                    'Xã Tân Ước', 'Xã Thanh Cao', 'Xã Thanh Mai', 'Xã Thanh Thùy', 'Xã Thanh Văn',
                    'Xã Xuân Dương'
                ],
                district23: [
                    'Thị trấn Liên Quan', 'Xã Bình Phú', 'Xã Bình Yên', 'Xã Cẩm Yên', 'Xã Cần Kiệm',
                    'Xã Canh Nậu', 'Xã Chàng Sơn', 'Xã Đại Đồng', 'Xã Dị Nậu', 'Xã Đồng Trúc',
                    'Xã Hạ Bằng', 'Xã Hương Ngải', 'Xã Hữu Bằng', 'Xã Kim Quan', 'Xã Lại Thượng',
                    'Xã Phú Kim', 'Xã Phùng Xá', 'Xã Tân Xã', 'Xã Thạch Hòa', 'Xã Thạch Xá',
                    'Xã Tiến Xuân', 'Xã Yên Bình', 'Xã Yên Trung'
                ],
                district24: [
                    'Thị trấn Vân Đình', 'Xã Cao Thành', 'Xã Đại Cường', 'Xã Đại Hùng', 'Xã Đội Bình',
                    'Xã Đông Lỗ', 'Xã Đồng Tiến', 'Xã Đồng Tân', 'Xã Hoa Sơn', 'Xã Hòa Lâm',
                    'Xã Hòa Nam', 'Xã Hòa Phú', 'Xã Hòa Xá', 'Xã Hồng Quang', 'Xã Kim Đường',
                    'Xã Liên Bạt', 'Xã Lưu Hoàng', 'Xã Minh Đức', 'Xã Phù Lưu', 'Xã Phương Tú',
                    'Xã Quảng Phú Cầu', 'Xã Sơn Công', 'Xã Tảo Dương Văn', 'Xã Trầm Lộng', 'Xã Trung Tú',
                    'Xã Trường Thịnh', 'Xã Vạn Thái', 'Xã Viên An', 'Xã Viên Nội'
                ],
                district25: [
                    'Thị trấn Đại Nghĩa', 'Xã An Mỹ', 'Xã An Phú', 'Xã An Tiến', 'Xã Bột Xuyên',
                    'Xã Đại Hưng', 'Xã Đốc Tín', 'Xã Đồng Tâm', 'Xã Hồng Sơn', 'Xã Hợp Thanh',
                    'Xã Hợp Tiến', 'Xã Hùng Tiến', 'Xã Hương Sơn', 'Xã Lê Thanh', 'Xã Mỹ Thành',
                    'Xã Phù Lưu Tế', 'Xã Phúc Lâm', 'Xã Phùng Xá', 'Xã Thượng Lâm', 'Xã Tuy Lai',
                    'Xã Vạn Kim', 'Xã Xuy Xá'
                ],
                district26: [
                    'Thị trấn Quốc Oai', 'Xã Cấn Hữu', 'Xã Cộng Hòa', 'Xã Đại Thành', 'Xã Đồng Quang',
                    'Xã Đông Yên', 'Xã Hòa Thạch', 'Xã Liệp Tuyết', 'Xã Nghĩa Hương', 'Xã Ngọc Liệp',
                    'Xã Ngọc Mỹ', 'Xã Phú Cát', 'Xã Phú Mãn', 'Xã Phượng Cách', 'Xã Sài Sơn',
                    'Xã Tân Hòa', 'Xã Tân Phú', 'Xã Thạch Thán', 'Xã Tuyết Nghĩa', 'Xã Yên Sơn',
                    'Xã Đông Xuân'
                ],
                district27: [
                    'Thị trấn Phúc Thọ', 'Xã Hát Môn', 'Xã Hiệp Thuận', 'Xã Liên Hiệp', 'Xã Long Xuyên',
                    'Xã Ngọc Tảo', 'Xã Phúc Hòa', 'Xã Phụng Thượng', 'Xã Sen Phương', 'Xã Tam Hiệp',
                    'Xã Tam Thuấn', 'Xã Thanh Đa', 'Xã Thọ Lộc', 'Xã Thượng Cốc', 'Xã Tích Giang',
                    'Xã Trạch Mỹ Lộc', 'Xã Vân Hà', 'Xã Vân Nam', 'Xã Vân Phúc', 'Xã Võng Xuyên',
                    'Xã Xuân Đình'
                ],
                district28: [
                    'Thị trấn Phùng', 'Xã Đan Phượng', 'Xã Đồng Tháp', 'Xã Hạ Mỗ', 'Xã Hồng Hà',
                    'Xã Liên Hà', 'Xã Liên Hồng', 'Xã Liên Trung', 'Xã Phương Đình', 'Xã Song Phượng',
                    'Xã Tân Hội', 'Xã Tân Lập', 'Xã Thọ An', 'Xã Thọ Xuân', 'Xã Thượng Mỗ',
                    'Xã Trung Châu'
                ],
                district29: [
                    'Lê Lợi', 'Ngô Quyền', 'Phú Thịnh', 'Quang Trung', 'Sơn Lộc',
                    'Trung Hưng', 'Trung Sơn Trầm', 'Viên Sơn', 'Xuân Khanh',
                    'Xã Cổ Đông', 'Xã Đường Lâm', 'Xã Kim Sơn', 'Xã Sơn Đông', 'Xã Thanh Mỹ', 'Xã Xuân Sơn'
                ]
            };

            const districtSelect = document.getElementById('district');
            districts.forEach(district => {
                const option = document.createElement('option');
                option.value = district.id;
                option.textContent = district.name;
                option.setAttribute("data-name", district.name);
                districtSelect.appendChild(option);
            });

            districtSelect.addEventListener('change', function () {
                const wardSelect = document.getElementById('ward');
                wardSelect.innerHTML = '<option value="" selected>Chọn phường xã</option>'; // Reset phường xã

                const selectedDistrictId = this.value; // Lấy id quận huyện
                if (wards[selectedDistrictId]) {
                    wards[selectedDistrictId].forEach(ward => {
                        const option = document.createElement('option');
                        option.value = ward;
                        option.textContent = ward;
                        wardSelect.appendChild(option);
                    });
                }

            });

        },
        handleFileSelect(event) {
            const files = Array.from(event.target.files);

            files.forEach(file => {
                const url = URL.createObjectURL(file);
                this.previews.push({
                    file: file,
                    url: url
                });
            });

        },
        handleDelete(index) {
            // Revoke URL của preview
            URL.revokeObjectURL(this.previews[index].url);


            this.previews.splice(index, 1);


            const dataTransfer = new DataTransfer();


            this.previews.forEach(preview => {
                dataTransfer.items.add(preview.file);
            });


            this.$refs.fileInput.files = dataTransfer.files;
        },
        getFiles() {
            return this.previews.map(preview => preview.file);
        },
        toAdvancedSearchPage() {
            this.$router.push('/advanced-search')
        },
        async fetchMotelEdit(id) {
            const response = await axios.get(`http://localhost:8081/motel/${id}`)
            this.title = response.data.title
            this.area = response.data.area
            this.price = response.data.price
            this.maxPeople = response.data.maxPeople
            this.type = response.data.type
            this.detail = response.data.detail
            this.currents = response.data.filesDTO
        
            if (this.userInfo.id != response.data.owner.id) this.$router.push('/')
        },
        async handleDeleteImg(fileId) {
            this.listFileId.push(fileId)
            this.currents = this.currents.filter(preview => preview.id !== fileId);
        }
    },
    beforeDestroy() {
        this.previews.forEach(preview => {
            URL.revokeObjectURL(preview.url);
        });
    },
    computed: {
        hasToken() {
            return !!localStorage.getItem('token');
        }
    }
};

</script>
<style scoped>
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

@media (max-width: 768px) {
    .col-lg-6 {
        flex: 0 0 100%;
        margin-bottom: 1rem;
    }
}

.loading-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999;
}

.spinner-border {
    width: 3rem;
    height: 3rem;
}

.preview-container {
    position: relative;
}

.delete-btn {
    position: absolute;
    top: 5px;
    right: 5px;
    padding: 0.25rem 0.5rem;
    opacity: 0;
    transition: opacity 0.2s ease-in-out;
}

.preview-container:hover .delete-btn {
    opacity: 1;
}
</style>