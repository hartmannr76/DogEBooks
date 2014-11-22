jQuery(document).ready(function() {
    	 $('.indexBlock').hover(function() {
        //Display the caption
        $(this).find('div.caption').stop(false,true).fadeIn(200);
        $(this).parent().find('a.indexItem').stop(false,true).slideToggle(200);
    	},
	    function() {
	        //Hide the caption
	        $(this).find('div.caption').stop(false,true).fadeOut(200);
	        $(this).parent().find('a.indexItem').stop(false,true).slideToggle(200);
	    });
	    
	    var browseButton = $('.browse');
	    var wishlistButton = $('.wish');
	    var cartButton = $('.cart');
	    var notificationButton = $('.notify');
	    
	    function unselectTops() {
	    	browseButton.removeClass('select');
	    	wishlistButton.removeClass('select');
	    	cartButton.removeClass('select');
	    	notificationButton.removeClass('select');
	    }
	    
	    function processClick(buttonClicked) {
	    	if (buttonClicked == browseButton)
	    	{
	    			browseButton.toggleClass('select');
	    			$('.browseSelection').toggle();
	    	}
	    	else{
	    		$('.browseSelection').hide();
	    		browseButton.removeClass('select');}
	    		
	    	if (buttonClicked == wishlistButton)
	    	{	
	    			wishlistButton.toggleClass('select');
	    			$('.wishList').toggle();
	    	}
	    	else{
	    		$('.wishList').hide();
	    		wishlistButton.removeClass('select');}
	    		
	    	if (buttonClicked == cartButton)
	    	{
	    			cartButton.toggleClass('select');
	    			$('.cartList').toggle();
	    	}
	    	else{
	    		$('.cartList').hide();
	    		cartButton.removeClass('select');}
	    		
	    	if (buttonClicked == notificationButton)
	    	{
	    			notificationButton.toggleClass('select');
	    			$('.notificationList').toggle();
	    	}
	    	else{
	    		$('.notificationList').hide();
	    		notificationButton.removeClass('select');}
	    }
	    
	    browseButton.click(function() {
	    	processClick(browseButton);
	    });
	    
	    wishlistButton.click(function() {
	    	processClick(wishlistButton);
	    });
	    
	    cartButton.click(function() {
	    	processClick(cartButton);
	    });
	    
	    notificationButton.click(function() {
	    	processClick(notificationButton);
	    });
	    
	    $('.logBlock').click(function() {
	    	$('.loginBox').toggle();
	    });
    });