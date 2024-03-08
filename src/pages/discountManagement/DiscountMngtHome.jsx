
import "../../css/mngtHome.css"
import Navbar from '../../components/navbar/Navbar';
import Sidebar from '../../components/sidebar/Sidebar';
import TabContent from "../../components/tab-content/tab-content";
import { Link } from "react-router-dom";
import AllTableDiscountMngt from "../../components/tableDiscountMngtHome/AllTableDiscountMngt";
import ActiveTableDiscountMngt from "../../components/tableDiscountMngtHome/ActiveTableDiscountMngt";
import StorageTableDiscountMngt from "../../components/tableDiscountMngtHome/StorageTableDiscountMngt ";

import SearchOutlinedIcon from "@mui/icons-material/SearchOutlined";
import ExpiredTableDiscountMngt from "../../components/tableDiscountMngtHome/ExpiredTableDiscountMngt";

const DiscountMngtHome = () => {
    const contents = [
        {
            title: "Tất cả khuyến mãi",
            content: (
                <AllTableDiscountMngt />
            ),
        },
        {
            title: "Khuyến mãi đang áp dụng",
            content: (
                <ActiveTableDiscountMngt />
            ),
        },
        {
            title: "Khuyến mãi đã lưu kho",
            content: (
                <StorageTableDiscountMngt />
            ),
        },
        {
            title: "Khuyến mãi đã hết hạn",
            content: (
                <ExpiredTableDiscountMngt />
            ),
        },

    ];
    return (
        <div className='list'>
            <Sidebar />
            <div className="listContainer">
                <Navbar title="Quản lý khuyến mãi" />
                <div className="headerMngt">
                    <div className="search">
                        <input type="text" placeholder="Search..." />
                        <div className='icon'>
                            <SearchOutlinedIcon />
                        </div>
                    </div>
                    <div className="linkAdd">
                        <Link to="/discountManagement/addDiscount" style={{ textDecoration: "none" }}>
                            <div className="textAdd">Thêm khuyến mãi</div>
                        </Link>
                    </div>
                </div>
                <TabContent input={contents} />
            </div>


        </div>

    )
}

export default DiscountMngtHome