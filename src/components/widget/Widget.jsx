
import "./widget.css";
//icon 
import ExpandLessIcon from '@mui/icons-material/ExpandLess';

//user
import PersonIcon from '@mui/icons-material/Person';

import StoreIcon from '@mui/icons-material/Store';

import ReceiptLongIcon from '@mui/icons-material/ReceiptLong';

import ForumIcon from '@mui/icons-material/Forum';

const Widget = ({ type }) => {
    let data;

    //temporary
    const amount = 100
    const diff = 20

    switch (type) {
        case "product":
            data = {
                title: "MÓN ĂN",
                isMoney: false,
                link: "Xem tất cả món ăn",
                icon: <StoreIcon className="icon" />,
            };
            break;

        case "order":
            data = {
                title: "ĐƠN HÀNG",
                isMoney: false,
                link: "Xem tất cả đơn hàng",
                icon: <ReceiptLongIcon className="icon" />,
            };
            break;

        case "comment":
            data = {
                title: "ĐÁNH GIÁ",
                isMoney: false,
                link: "Xem tất cả đánh giá",
                icon: <ForumIcon className="icon" />,
            };
            break;

        case "user":
            data = {
                title: "KHÁCH HÀNG",
                isMoney: false,
                link: "Xem tất cả khách hàng",
                icon: <PersonIcon className="icon" />,
            };
            break;
        default:
            break;
    }

    return (
        <div className="widget">
            <div className="left">
                <span className="titlehome">{data.title}</span>
                <span className="counter">{data.isMoney && "$"} {amount}</span>
                <span className="link">{data.link}</span>
            </div>
            <div className="right">
                <div className="percentage positive"><ExpandLessIcon />{diff}%</div>
                {data.icon}
            </div>
        </div>
    )
}

export default Widget