import "./featured.css"

//icon
import MoreVertIcon from '@mui/icons-material/MoreVert';

//chart
import { CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
const Featured = () => {
    return (
        <div className='featured'>
            <div className="top">
                <h1 className="title">Tổng doanh thu</h1>
                <MoreVertIcon fontSize="small" className="icon" />
            </div>
            <div className="bottom">
                <div className="featuredChart">
                    <CircularProgressbar value={70} text={"70%"} strokeWidth={5} />
                </div>
                <p className="title">Tổng doanh thu hôm nay</p>
                <p className="amount">$420</p>
                <p className="desc">Các khoản thanh toán tính trong giờ kinh doanh</p>
            </div>
        </div>
    )
}

export default Featured