
function deleteTrip(tripId) {
    if (confirm("Bạn có chắc chắn xóa không?") == true) {
        fetch(`/BookTicketWebApp/api/trips/${tripId}`, {
            mothod: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            if (res.status == 200) {
                let d = document.getElementById(`trip${tripId}`);
                d.style.display = "none";
            } else{
                alert("Someting wrong!!");
            }
        })
    }
}

function deleteRoute(routeId) {
    if (confirm("Bạn có chắc chắn xóa không?") == true) {
        fetch(`/BookTicketWebApp/api/routes/${routeId}`, {
            mothod: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            if (res.status == 200) {
                let d = document.getElementById(`route${routeId}`);
                d.style.display = "none";
            } else{
                alert("Someting wrong!!");
            }
        })
    }
}

