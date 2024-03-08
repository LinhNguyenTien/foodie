
import "../../css/mngtHome.css"
import Navbar from '../../components/navbar/Navbar';
import Sidebar from '../../components/sidebar/Sidebar';
import TabContent from "../../components/tab-content/tab-content";
//import { Link } from "react-router-dom";
import AllTableOrderMngt from "../../components/tableOrderMngtHome/AllTableOrderMngt";
import ProcessingTableOrderMngt from "../../components/tableOrderMngtHome/ProcessingTableOrderMngt";
import ApprovedTableOrderMngt from "../../components/tableOrderMngtHome/ApprovedTableOrderMngt ";
import CompleteTableOrderMngt from "../../components/tableOrderMngtHome/CompleteTableOrderMngt";
import CancelTableOrderMngt from "../../components/tableOrderMngtHome/CancelTableOrderMngt";

import SearchOutlinedIcon from "@mui/icons-material/SearchOutlined";

const OrderMngtHome = () => {
    const contents = [
        {
            title: "Tất cả đơn hàng",
            content: (
                <AllTableOrderMngt />
            ),
        },
        {
            title: "Đơn hàng chờ duyệt",
            content: (
                <ProcessingTableOrderMngt />
            )
        },
        {
            title: "Đơn hàng đang giao ",
            content: (
                <ApprovedTableOrderMngt />
            ),
        },

        {
            title: "Đơn hàng đã giao",
            content: (
                <CompleteTableOrderMngt />
            ),
        },
        {
            title: "Đơn hàng đã hủy",
            content: (
                <CancelTableOrderMngt />
            ),
        },

    ];
    return (
        <div className='list'>
            <Sidebar />
            <div className="listContainer">
                <Navbar title="Quản lý đơn hàng" />
                <div className="headerMngt">
                    {/* <div className="linkAdd">
                        <Link to="/productManagement/addProduct" style={{ textDecoration: "none" }}>
                            <div className="textAdd">Thêm món ăn</div>
                        </Link>
                    </div> */}
                    <div className="search">
                        <input type="text" placeholder="Search..." />
                        <div className='icon'>
                            <SearchOutlinedIcon />
                        </div>
                    </div>
                </div>
                <TabContent input={contents} />
            </div>


        </div>

    )
}

export default OrderMngtHome