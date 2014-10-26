$("document").ready(function() {

    var driver = $(".media-heading").data('username');
    var commentSection = $(".all-comments");

    function getComments() {
        $(".error-message-group").hide();
        $(".error-message").html("");
        commentSection.html("");
        $(".total-rating").html("");
        $.get("driver/ratings?d=" + driver, function(data) {
            var numberOfComments = 0;
            var average = 0;
            if (data.length === 0) {
                $(".total-rating").html("Driver not yet rated");
                return;
            }
            for (var i = 0; i < data.length; i++) {
                var html = "<a href='#' class='list-group-item'>";
                html += "<h4 class='list-group-item-heading'>" + data[i].username + "<span class='pull-right'>" + data[i].rating + " / 5</span> </h4>";
                html += "<p class='list-group-item-text'>" + data[i].comment + "</p>";
                html += "</a>";
                commentSection.append(html);
                numberOfComments++;
                average += data[i].rating;
            }
            $(".number-of-comments").html(numberOfComments);
            average = average / numberOfComments;
            average = Math.round(average*2)/2;
            $(".total-rating").html(average + " / 5");
        });
    }
    getComments();



    $(".add-comment").on('click', function() {
        $(".add-comment-form").show();
        $(".add-comment").hide();
    });

    $(".send-comment").on('click', function() {
       var json = {
           "comment": $("#message").val(),
           "rating" : $(".selected-rating option:selected").text(),
           "driver": driver
        };

        if (json.comment.length > 0) {
            $.ajax({
                type: "POST",
                url: "driver/comment",
                data: JSON.stringify(json),
                contentType: 'text/json',
                success: function(data) {
                    console.log(data);
                    if (data === "OK") {
                        getComments();
                        $(".add-comment-form").hide();
                        $(".add-comment").show();
                        $("#message").val("");
                    } else {
                        console.log("something went wrong");
                        $(".error-message-group").show();
                        $(".error-message").html("Comment can not be empty");
                    }
                }
            });
        } else {
            $(".error-message-group").show();
            $(".error-message").html("Comment can not be empty");

        }




    });

    $(".cancel-comment").on('click', function() {
        $(".add-comment-form").hide();
        $(".add-comment").show();
    });
});