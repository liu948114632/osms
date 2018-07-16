
CREATE PROC p_fba_shop_product
(
  @isSeaTransportBlackList INT=NULL,
	@shopId INT=NULL,
	@sku VARCHAR(100)=NULL,
	@skus VARCHAR(max)=NULL,
	@cmsProductCode VARCHAR(100)=NULL,
	@cmsProductCodes VARCHAR(max)=NULL,
	@status INT =NULL,
	@PageSize INT = 50 ,  --页大小                          
    @PageIndex INT = 1    --当前页号   
)
AS
BEGIN
    DECLARE @SQL VARCHAR(MAX) ,  
    @CountSql NVARCHAR(MAX) , --查询数量用    
    @FromSQL NVARCHAR(MAX) , --查询表                                           
    @Column NVARCHAR(MAX) , --查询字段                         
    @Condition VARCHAR(MAX) , --条件                           
    @RowCount INT ,  
    @PageCount INT ,  
    @start INT ,  
    @end INT 

	--设置查询主表      
    SET @FromSQL = ' FROM dbo.fba_shop_product f
			LEFT JOIN dbo.shop_product_cms_info cms ON cms.cms_product_id = f.cms_product_id '  
             
    SET @Condition = ' WHERE  1=1 '                

	--设置查询条件
  IF @isSeaTransportBlackList IS NOT NULL
    BEGIN
      SET @Condition = @Condition + ' AND f.is_sea_transportation_blacklist=' + CONVERT(VARCHAR(10), @isSeaTransportBlackList)

    END

  IF @shopId IS NOT NULL
		BEGIN  
			SET @Condition = @Condition + ' AND f.shop_id=' + CONVERT(VARCHAR(10), @shopId)   
             
		END    
	
	 IF @status IS NOT NULL   
		BEGIN  
			SET @Condition = @Condition + ' AND f.status=' + CONVERT(VARCHAR(10), @status)   
             
		END   

	IF @cmsProductCodes IS NOT NULL  
		BEGIN  
			SET @Condition = @Condition + ' AND f.cms_product_code in (''' + REPLACE(@cmsProductCodes,',',''',''') + ''')'     
		END  

	IF @cmsProductCode IS NOT NULL  
		BEGIN  
			SET @Condition = @Condition + ' AND  f.cms_product_code like ''' + @cmsProductCode + '%''';  
		END 

	IF @skus IS NOT NULL  
		BEGIN  
			SET @Condition = @Condition + ' AND f.sku in (''' + REPLACE(@skus,',',''',''') + ''')'     
		END  

	IF @sku IS NOT NULL  
		BEGIN  
			SET @Condition = @Condition + ' AND  f.sku like ''' + @sku + '%''';  
		END 

	--设置需要取的字段信息                          
        SET @Column = '  
		
		f.id ,
           f.shop_id shopId,
           f.sku ,
           f.fba_barcode_name fbaBarcodeName ,
           f.fba_barcode_sku fbaBarcodeSku,
           f.cms_product_id cmsProductId,
           f.cms_product_code cmsProductCode,
					 f.is_sea_transportation_blacklist isSeaTransportationBlacklist,
           f.status ,
           cms.product_name as productName,
           cms.unit_quantity unitQuantity,
           cms.primary_picture_code primaryPictureCode,
           cms.unit 
         '


	
    --求符合条件的总数                        
    SET @CountSql = ' SELECT @RowCount = count(f.id) ' + @FromSQL + @Condition                   
    EXEC sp_executesql @CountSql, N'@RowCount INT OUT', @RowCount OUT              
                              
    
    IF ISNULL(@PageSize, 0) < 1   
        SET @PageSize = 50                                
    SET @PageCount = ( @RowCount + @PageSize - 1 ) / @PageSize                                
    IF ISNULL(@PageIndex, 0) < 1   
        SET @PageIndex = 1                                
    ELSE   
        IF ISNULL(@PageIndex, 0) > @PageCount   
            SET @PageIndex = @PageCount                                
    SET @start = ( @PageIndex - 1 ) * @PageSize + 1                                
    SET @end = @PageIndex * @PageSize    

	  SET @SQL = 'SELECT * from                        
       (                        
       SELECT *,ROW_NUMBER() OVER(ORDER BY temp.status asc,sku ASC) rowIndex                        
       from (SELECT ' +@Column + @FromSQL + @Condition  
            + ') temp                        
       ) temp2                             
       where rowIndex between ' + CAST(@start AS NVARCHAR(10)) + ' and '  
            + CAST(@end AS NVARCHAR(10))      
              
        EXEC(@SQL);   
        PRINT @SQL;              
        SELECT  @RowCount 
END


go

