ALTER TABLE  `order_by_product` CHANGE  `price`  `price` DECIMAL NOT NULL;
ALTER TABLE  `order_by_product` CHANGE  `orderbyproductID`  `orderByProductID` INT( 11 ) NOT NULL AUTO_INCREMENT;
ALTER TABLE  `restaurant_table` CHANGE  `commentorder`  `commentOrder` VARCHAR( 255 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;

ALTER TABLE `cafeplatform`.`restaurant`
CHANGE COLUMN `useGst` `useGst` INT(11) NULL ,
CHANGE COLUMN `gstRate` `gstRate` DOUBLE NULL ;