
import "../../css/mngtHome.css"
import Navbar from '../../components/navbar/Navbar';
import Sidebar from '../../components/sidebar/Sidebar';

import AllTableProductMngt from "../../components/tableProductMngtHome/AllTableProductMngt";
import HiddenTableProductMngt from "../../components/tableProductMngtHome/HiddenTableProductMngt ";
import TabContent from "../../components/tab-content/tab-content";
import { Link } from "react-router-dom";
import ActiveTableProductMngt from "../../components/tableProductMngtHome/ActiveTableProductMngt";

import SearchOutlinedIcon from "@mui/icons-material/SearchOutlined";

const ProductMngtHome = () => {
    const contents = [
        {
            title: "Tất cả Món ăn",
            content: (
                <AllTableProductMngt />
            ),
        },
        {
            title: "Món ăn đang bán",
            content: (
                <ActiveTableProductMngt />
            ),
        },

        {
            title: "Món ăn đã ẩn",
            content: (
                <HiddenTableProductMngt />
            ),
        },
    ];
    return (
        <div className='list'>
            <Sidebar />
            <div className="listContainer">
                <Navbar title="Quản lý món ăn" />
                <div className="headerMngt">
                    <div className="search">
                        <input type="text" placeholder="Search..." />
                        <div className='icon'>
                            <SearchOutlinedIcon />
                        </div>
                    </div>
                    <div className="linkAdd">
                        <Link to="/productManagement/addProduct" style={{ textDecoration: "none" }}>
                            <div className="textAdd">Thêm món ăn</div>
                        </Link>
                    </div>
                </div>
                <TabContent input={contents} />
            </div>


        </div>

    )
}

export default ProductMngtHome