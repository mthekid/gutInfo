$('.extra-fields-bacteria-info').click(function() {
  $('.bacteria_info').clone().appendTo('.bacteria_info_dynamic');
  $('.bacteria_info_dynamic .bacteria_info').addClass('single remove');
  $('.single .extra-fields-bacteria-info').remove();
  $('.single').append('<a href="#" class="remove-field btn-remove-customer">Remove Fields</a>');
  $('.bacteria_info_dynamic > .single').attr("class", "remove");

  $('.bacteria_info_dynamic input').each(function() {
    var count = 0;
    var fieldname = $(this).attr("name");
    $(this).attr('name', fieldname + count);
    count++;
  });

});

$(document).on('click', '.remove-field', function(e) {
  $(this).parent('.remove').remove();
  e.preventDefault();
});