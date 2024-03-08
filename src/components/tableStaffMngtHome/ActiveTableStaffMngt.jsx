import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { staffMngtColumns, activeStaffMngtRows } from "../../data/dataStaffMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";



const ActiveTableStaffMngt = () => {

    const [data, setData] = useState(activeStaffMngtRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };
    const handleBlock = (id) => {
        setData(data.filter((item) => item.id !== id));
    };
    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 250,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/staffManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>
                        <div
                            className="blockButton"
                            onClick={() => handleBlock(params.row.id)}
                        >
                            Khóa
                        </div>
                        <div
                            className="deleteButton"
                            onClick={() => handleDelete(params.row.id)}
                        >
                            Xóa
                        </div>
                    </div>
                );
            },
        },
    ];

    return (
        <div className="datatable" >
            <DataGrid className="datagrid"
                rows={data}
                columns={staffMngtColumns.concat(actionColumn)}
                //columns={staffMngtColumns}
                initialState={{
                    pagination: {
                        paginationModel: { page: 0, pageSize: 9 },
                    },
                }}
                pageSizeOptions={[9]}
                checkboxSelection
            />
        </div>
    )
}

export default ActiveTableStaffMngt 