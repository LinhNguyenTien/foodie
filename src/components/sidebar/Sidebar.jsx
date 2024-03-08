import React from 'react'
import "./sidebar.css"


import HomeIcon from '@mui/icons-material/Home';

import { Link } from "react-router-dom"
//import {} from "@mui/icons-material"

//tk
import SignalCellularAltIcon from '@mui/icons-material/SignalCellularAlt';
//import PollIcon from '@mui/icons-material/Poll';

//spbc
import KeyboardDoubleArrowUpIcon from '@mui/icons-material/KeyboardDoubleArrowUp';


//tkkh
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';


//tkdt
import PriceChangeIcon from '@mui/icons-material/PriceChange';
//import MonetizationOnIcon from '@mui/icons-material/MonetizationOn';

//tkdg
//import CommentIcon from '@mui/icons-material/Comment';
import ForumIcon from '@mui/icons-material/Forum';

//qlkh
import PersonIcon from '@mui/icons-material/Person';
//import PortraitIcon from '@mui/icons-material/Portrait';

//qlnv
import ManageAccountsIcon from '@mui/icons-material/ManageAccounts';

//qldm
import PlaylistAddIcon from '@mui/icons-material/PlaylistAdd';

//qlkm
import DiscountIcon from '@mui/icons-material/Discount';
//import PercentIcon from '@mui/icons-material/Percent';

//qldh
import ReceiptLongIcon from '@mui/icons-material/ReceiptLong';

//qlsp
import StoreIcon from '@mui/icons-material/Store';
//import StorefrontIcon from '@mui/icons-material/Storefront';


//cd
import SettingsSuggestIcon from '@mui/icons-material/SettingsSuggest';

//mk
import MiscellaneousServicesIcon from '@mui/icons-material/MiscellaneousServices';

//night
//import NightlightIcon from '@mui/icons-material/Nightlight';


//logout
import ExitToAppIcon from '@mui/icons-material/ExitToApp';


//mắt
//import RemoveRedEyeIcon from '@mui/icons-material/RemoveRedEye';


//bật
//import ToggleOffIcon from '@mui/icons-material/ToggleOff';

//tắt tr th
const sidebar = () => {
    return (
        <div className='sidebar'>
            <div className="top">
                <span className="name"> Ten</span>
            </div>
            <hr />
            <div className="center">
                <ul>
                    <Link to="/" style={{ textDecoration: "none" }}>
                        <li className='titleHome'>


                            <HomeIcon className='iconTitle' />
                            <span className='titleHomeText'>Trang chủ</span>

                        </li>
                    </Link>
                    <p className="titleSidebar">
                        <SignalCellularAltIcon className='iconTitle' />Thống kê</p>

                    <li>
                        <KeyboardDoubleArrowUpIcon className='icon' />
                        <span>Sản phẩm bán chạy</span>
                    </li>

                    <li>
                        <PriceChangeIcon className='icon' />
                        <span>Doanh thu</span>
                    </li>

                    <li>
                        <ForumIcon className='icon' />
                        <span>Đánh giá</span>
                    </li>

                    <li>
                        <PeopleAltIcon className='icon' />
                        <span>Khách hàng</span>
                    </li>

                    <p className="titleSidebar"><PlaylistAddIcon className='iconTitle' />Quản lý danh mục</p>

                    <Link to="/staffManagement" style={{ textDecoration: "none" }}>
                        <li>
                            <ManageAccountsIcon className='icon' />
                            <span>Quản lý nhân viên</span>
                        </li>
                    </Link>

                    <Link to="/productManagement" style={{ textDecoration: "none" }}>
                        <li>
                            <StoreIcon className='icon' />
                            <span>Quản lý món ăn</span>
                        </li>
                    </Link>

                    <Link to="/orderManagement" style={{ textDecoration: "none" }}>
                        <li>
                            <ReceiptLongIcon className='icon' />
                            <span>Quản lý đơn hàng</span>
                        </li>
                    </Link>

                    <Link to="/discountManagement" style={{ textDecoration: "none" }}>
                        <li>
                            <DiscountIcon className='icon' />
                            <span>Quản lý khuyến mãi</span>
                        </li>
                    </Link>

                    <Link to="/customerManagement" style={{ textDecoration: "none" }}>
                        <li>
                            <PersonIcon className='icon' />
                            <span>Quản lý khách hàng</span>
                        </li>
                    </Link>

                    <p className="titleSidebar"><SettingsSuggestIcon className='iconTitle' />Cài đặt</p>

                    <Link to="/setting/changePassword" style={{ textDecoration: "none" }}>
                        <li>
                            <MiscellaneousServicesIcon className='icon' />
                            <span>Đổi mật khẩu</span>
                        </li>
                    </Link>

                    <Link to="/login" style={{ textDecoration: "none" }}>
                        <li>
                            <ExitToAppIcon className='icon' />
                            <span>Đăng xuất</span>
                        </li>
                    </Link>
                </ul>
            </div>

            {/* <div className="bottom">

                <div className="colorOption"></div>
                <div className="colorOption"></div>

            </div> */}
        </div>
    )
}

export default sidebar