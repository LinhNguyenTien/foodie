import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { staffMngtColumns, blockStaffMngtRows } from "../../data/dataStaffMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";



const BlockTableStaffMngt = () => {

    const [data, setData] = useState(blockStaffMngtRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };
    const handleUnlock = (id) => {
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
                            className="activeButton"
                            onClick={() => handleUnlock(params.row.id)}
                        >
                            Mở khóa
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

export default BlockTableStaffMngt 