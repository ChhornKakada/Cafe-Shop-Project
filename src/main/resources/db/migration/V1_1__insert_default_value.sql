-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table cafe_shop.addon: ~0 rows (approximately)
/*!40000 ALTER TABLE `addon` DISABLE KEYS */;
/*!40000 ALTER TABLE `addon` ENABLE KEYS */;

-- Dumping data for table cafe_shop.addon_detail: ~0 rows (approximately)
/*!40000 ALTER TABLE `addon_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `addon_detail` ENABLE KEYS */;

-- Dumping data for table cafe_shop.category: ~3 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`) VALUES
	(3, 'Frappe'),
	(1, 'Hot'),
	(2, 'Iced');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping data for table cafe_shop.employee: ~2 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `dob`, `hired_date`, `img`, `last_login`, `name`, `password`, `sex`, `username`, `role_id`) VALUES
	(1, '2023-05-06', '2023-05-06', '', '2023-05-06 16:46:15', 'Chorn Kakada', '123456', 'M', 'Kakada', 1),
	(2, '2023-05-06', '2023-05-06', '', '2023-05-06 16:46:15', 'Hang Nimith', '123456', 'M', 'Nimith', 2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping data for table cafe_shop.invoice: ~0 rows (approximately)
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;

-- Dumping data for table cafe_shop.invoice_detail: ~0 rows (approximately)
/*!40000 ALTER TABLE `invoice_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_detail` ENABLE KEYS */;

-- Dumping data for table cafe_shop.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `type`) VALUES
	(1, 'Admin'),
	(2, 'Cashier');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping data for table cafe_shop.size: ~3 rows (approximately)
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` (`id`, `size`) VALUES
	(3, 'Large'),
	(2, 'Medium'),
	(1, 'Small');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;

-- Dumping data for table cafe_shop.sustenance: ~21 rows (approximately)
/*!40000 ALTER TABLE `sustenance` DISABLE KEYS */;
INSERT INTO `sustenance` (`id`, `description`, `img`, `name`, `type_id`) VALUES
	(1, 'A traditional Italian coffee drink made with espresso and steamed milk, and topped with a layer of foamed milk.', NULL, 'Cappuccino', 1),
	(2, 'A coffee drink made with espresso and steamed milk, topped with a thin layer of foamed milk.', NULL, 'Latte', 1),
	(3, 'A simple coffee drink made with espresso and hot water, similar to a drip coffee.', NULL, 'Americano', 1),
	(4, 'A chocolate-flavored coffee drink made with espresso, steamed milk, and chocolate syrup or powder.', NULL, 'Mocha', 1),
	(5, 'An espresso-based coffee drink that is usually served with a dollop of frothed milk on top.', NULL, 'Macchiato', 1),
	(6, 'A strong coffee drink made by forcing hot water through finely ground coffee beans under high pressure.', NULL, 'Espresso', 1),
	(7, 'A coffee drink served over ice, usually made by brewing hot coffee and then chilling it.', NULL, 'Iced Coffee', 1),
	(8, 'A trademarked brand of blended coffee drink made by Starbucks, typically made with coffee, ice, milk, and sweeteners, and topped with whipped cream.', NULL, 'Frappuccino', 1),
	(9, 'A refreshing and tart drink made with freshly squeezed lemon juice, water, and sweetener (such as sugar or honey).', NULL, 'Lemonade', 1),
	(10, 'A sweet and creamy drink made with milk and ice cream, often flavored with fruits, chocolate, or other ingredients.', NULL, 'Milkshakes', 1),
	(11, 'A warm and comforting beverage made with cocoa powder, milk, and sugar, often topped with whipped cream or marshmallows.', NULL, 'Chocolate', 1),
	(12, 'a type of tea that is made from Camellia sinensis leaves and buds, and is known for its subtle flavor and health benefits.', NULL, 'Green tea', 1),
	(13, 'A popular Thai beverage made from strongly brewed Ceylon tea, spices, and condensed milk. It has a sweet and creamy flavor with a distinct orange color.', NULL, 'Thai tea', 1),
	(14, 'Acrescent-shaped pastry made of flaky dough that is crisp on the outside and soft on the inside.', NULL, 'Croissant ', 2),
	(15, 'A ring-shaped bread that is boiled before it is baked, giving it a chewy texture. Often served with cream cheese or lox.', NULL, 'Bagel ', 2),
	(16, 'A small, sweet cake that is often baked with fruit or nuts.', NULL, 'Muffin', 2),
	(17, 'A small, lightly sweetened cake that is similar to a biscuit. Often served with jam or clotted cream.', NULL, 'Scone ', 2),
	(18, 'A croissant filled with a variety of savory fillings such as ham, cheese, and tomato.', NULL, 'Croissant Sandwich', 2),
	(19, 'A savory pie that is typically made with eggs, cream, and cheese, and often contains vegetables or meat.', NULL, 'Quiche', 2),
	(20, 'An Italian-style omelette that is baked in the oven and often contains cheese and vegetables.', NULL, 'Frittata ', 2),
	(21, 'A  light and flaky pastry made from a laminated dough, or dough that is made by alternating layers of butter and dough.', NULL, 'Puff pastry', 2);
/*!40000 ALTER TABLE `sustenance` ENABLE KEYS */;

-- Dumping data for table cafe_shop.sustenance_detail: ~116 rows (approximately)
/*!40000 ALTER TABLE `sustenance_detail` DISABLE KEYS */;
INSERT INTO `sustenance_detail` (`id`, `price`, `category_id`, `size_id`, `sustenance_id`) VALUES
	(1, 2.50, 1, 1, 1),
	(2, 3.50, 1, 2, 1),
	(3, 4.50, 1, 3, 1),
	(4, 3.00, 2, 1, 1),
	(5, 4.00, 2, 2, 1),
	(6, 5.00, 2, 3, 1),
	(7, 4.00, 3, 1, 1),
	(8, 5.00, 3, 2, 1),
	(9, 6.00, 3, 3, 1),
	(10, 3.50, 1, 1, 2),
	(11, 4.50, 1, 2, 2),
	(12, 5.50, 1, 3, 2),
	(13, 4.00, 2, 1, 2),
	(14, 5.00, 2, 2, 2),
	(15, 6.00, 2, 3, 2),
	(16, 5.00, 3, 1, 2),
	(17, 6.00, 3, 2, 2),
	(18, 7.00, 3, 3, 2),
	(19, 2.00, 1, 1, 3),
	(20, 3.00, 1, 2, 3),
	(21, 4.00, 1, 3, 3),
	(22, 2.50, 2, 1, 3),
	(23, 3.50, 2, 2, 3),
	(24, 4.50, 2, 3, 3),
	(25, 3.00, 3, 1, 3),
	(26, 4.00, 3, 2, 3),
	(27, 5.00, 3, 3, 3),
	(28, 2.50, 1, 1, 4),
	(29, 3.00, 1, 2, 4),
	(30, 3.50, 1, 3, 4),
	(31, 2.75, 2, 1, 4),
	(32, 3.25, 2, 2, 4),
	(33, 3.75, 2, 3, 4),
	(34, 3.00, 3, 1, 4),
	(35, 3.50, 3, 2, 4),
	(36, 4.00, 3, 3, 4),
	(37, 3.50, 1, 1, 5),
	(38, 4.50, 1, 2, 5),
	(39, 5.50, 1, 3, 5),
	(40, 4.00, 2, 1, 5),
	(41, 5.00, 2, 2, 5),
	(42, 6.00, 2, 3, 5),
	(43, 4.50, 3, 1, 5),
	(44, 5.50, 3, 2, 5),
	(45, 6.50, 3, 3, 5),
	(46, 2.00, 1, 1, 6),
	(47, 2.50, 1, 2, 6),
	(48, 3.00, 1, 3, 6),
	(49, 2.50, 2, 1, 6),
	(50, 3.00, 2, 2, 6),
	(51, 3.50, 2, 3, 6),
	(52, 3.00, 3, 1, 6),
	(53, 3.50, 3, 2, 6),
	(54, 4.00, 3, 3, 6),
	(127, 2.50, 2, 1, 7),
	(128, 3.50, 2, 2, 7),
	(129, 4.50, 2, 3, 7),
	(130, 3.00, 3, 1, 7),
	(131, 4.00, 3, 2, 7),
	(132, 5.00, 3, 3, 7),
	(139, 3.50, 3, 1, 8),
	(140, 4.00, 3, 2, 8),
	(141, 4.50, 3, 3, 8),
	(142, 2.75, 1, 1, 9),
	(143, 3.25, 1, 2, 9),
	(144, 3.75, 1, 3, 9),
	(145, 3.00, 2, 1, 9),
	(146, 3.50, 2, 2, 9),
	(147, 4.00, 2, 3, 9),
	(148, 3.25, 3, 1, 9),
	(149, 3.70, 3, 2, 9),
	(150, 4.20, 3, 3, 9),
	(151, 2.50, 1, 1, 10),
	(152, 3.00, 1, 2, 10),
	(153, 3.50, 1, 3, 10),
	(154, 2.75, 2, 1, 10),
	(155, 3.25, 2, 2, 10),
	(156, 3.75, 2, 3, 10),
	(157, 3.25, 3, 1, 10),
	(158, 3.75, 3, 2, 10),
	(159, 4.25, 3, 3, 10),
	(160, 2.25, 1, 1, 11),
	(161, 2.75, 1, 2, 11),
	(162, 3.25, 1, 3, 11),
	(163, 2.25, 1, 1, 11),
	(164, 2.75, 1, 2, 11),
	(165, 3.25, 1, 3, 11),
	(166, 3.25, 3, 1, 11),
	(167, 3.75, 3, 2, 11),
	(168, 4.25, 3, 3, 11),
	(169, 2.50, 1, 1, 12),
	(170, 3.50, 1, 2, 12),
	(171, 4.50, 1, 3, 12),
	(172, 3.00, 2, 1, 12),
	(173, 4.00, 2, 2, 12),
	(174, 5.00, 2, 3, 12),
	(175, 4.00, 3, 1, 12),
	(176, 5.00, 3, 2, 12),
	(177, 6.00, 3, 3, 12),
	(178, 2.75, 1, 1, 13),
	(179, 3.75, 1, 2, 13),
	(180, 4.75, 1, 3, 13),
	(181, 2.75, 2, 1, 13),
	(182, 3.75, 2, 2, 13),
	(183, 4.75, 2, 3, 13),
	(184, 3.25, 3, 1, 13),
	(185, 4.25, 3, 2, 13),
	(186, 5.25, 3, 3, 13),
	(188, 2.99, NULL, NULL, 13),
	(189, 2.50, NULL, NULL, 14),
	(190, 2.50, NULL, NULL, 15),
	(191, 3.25, NULL, NULL, 16),
	(192, 4.25, NULL, NULL, 17),
	(193, 4.50, NULL, NULL, 18),
	(194, 3.75, NULL, NULL, 19),
	(195, 2.50, NULL, NULL, 20);
/*!40000 ALTER TABLE `sustenance_detail` ENABLE KEYS */;

-- Dumping data for table cafe_shop.tables: ~26 rows (approximately)
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` (`id`, `status`) VALUES
	(1, 'available'),
	(2, 'available'),
	(3, 'available'),
	(4, 'available'),
	(5, 'available'),
	(6, 'available'),
	(7, 'available'),
	(8, 'available'),
	(9, 'available'),
	(10, 'available'),
	(11, 'available'),
	(12, 'available'),
	(13, 'available'),
	(14, 'available'),
	(15, 'available'),
	(16, 'available'),
	(17, 'available'),
	(18, 'available'),
	(19, 'available'),
	(20, 'available'),
	(21, 'available'),
	(22, 'available'),
	(23, 'available'),
	(24, 'available'),
	(25, 'available'),
	(26, 'available');
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;

-- Dumping data for table cafe_shop.topping: ~0 rows (approximately)
/*!40000 ALTER TABLE `topping` DISABLE KEYS */;
INSERT INTO `topping` (`id`, `name`, `price`) VALUES
	(1, 'Marshmallow ', 0.75),
	(2, 'Creamer', 0.65),
	(3, 'Cherries', 1.00),
	(4, 'Caramel drizzle', 0.75),
	(5, 'Jelly', 0.50),
	(6, 'popping pearls', 0.80);
/*!40000 ALTER TABLE `topping` ENABLE KEYS */;

-- Dumping data for table cafe_shop.type: ~0 rows (approximately)
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`id`, `name`) VALUES
	(1, 'Drink'),
	(2, 'Food');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
