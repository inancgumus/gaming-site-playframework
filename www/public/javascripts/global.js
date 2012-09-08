$(
	// inner shadow u ayarla
	function()
	{
		$("#innerShadow").attr("width", $(window).width());
		$("#innerShadow").attr("height", $(window).height());
	}
	
	
);

$(window).resize(
	// inner shadow u ayarla
	function()
	{
		$("#innerShadow").attr("width", $(window).width());
		$("#innerShadow").attr("height", $(window).height());
	}
)
