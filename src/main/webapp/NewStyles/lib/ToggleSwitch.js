/**
 * toggle
 */
(function ($) {

    $.fn.toggleSwitch = function () {
        var id = this.attr("id"),
            switchDivId = id + "-switch";
        $("<div/>", {class: "onoffswitch", id: switchDivId}).insertAfter(this);
        $("div#" + switchDivId).append(this.clone().addClass('onoffswitch-checkbox'));
        $("<label/>", {
            class: "onoffswitch-label",
            id:"test",
            for: id
        }).appendTo("div#" + switchDivId);
        this.remove();
        //this.add();
    };
}(jQuery));
