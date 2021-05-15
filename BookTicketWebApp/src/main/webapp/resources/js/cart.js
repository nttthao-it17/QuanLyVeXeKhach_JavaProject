function addCart(tripId) {
    $.ajax({
        url: "/BookTicketWebApp/api/cart",
        type: "POST",
        data: {
            tripId: tripId,
            num: 1
        },
        success: function (data) {
            var a = $(".trip-count").text();
            a = a === "" ? 0:parseInt(a);
            $(".trip-count").text(a + 1);
        },
        error: function (jqXHR) {
            console.info(jqXHR);
        }
    });
}
