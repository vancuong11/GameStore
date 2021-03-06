USE [master]
GO
/****** Object:  Database [GameStore]    Script Date: 8/9/2021 1:24:59 PM ******/
CREATE DATABASE [GameStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\BookShop.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BookShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\BookShop_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GameStore] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GameStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GameStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GameStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GameStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GameStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GameStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [GameStore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GameStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GameStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GameStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GameStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GameStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GameStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GameStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GameStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GameStore] SET  ENABLE_BROKER 
GO
ALTER DATABASE [GameStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GameStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GameStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GameStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GameStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GameStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GameStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GameStore] SET RECOVERY FULL 
GO
ALTER DATABASE [GameStore] SET  MULTI_USER 
GO
ALTER DATABASE [GameStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GameStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GameStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GameStore] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [GameStore] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'GameStore', N'ON'
GO
USE [GameStore]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [varchar](20) NOT NULL,
	[Password] [varchar](30) NULL,
	[Fullname] [nvarchar](30) NULL,
	[Email] [nvarchar](50) NULL,
	[Image] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Authorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](20) NULL,
	[RoleId] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Favorities]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Favorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductId] [int] NULL,
	[Username] [varchar](20) NULL,
	[CreateDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NULL,
	[ProductId] [int] NULL,
	[Price] [float] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](20) NULL,
	[CreateDate] [date] NULL,
	[Address] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Products]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Price] [float] NULL,
	[CreateDate] [date] NULL,
	[Image] [varchar](50) NULL,
	[Available] [bit] NULL,
	[Description] [nvarchar](max) NULL,
	[Category] [int] NULL,
 CONSTRAINT [PK__Products__3214EC07D60E7C91] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 8/9/2021 1:24:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [nvarchar](20) NOT NULL,
	[Name] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Image]) VALUES (N'khoa', N'123', N'Pham Hoang Khoa', N'khoa@gmail.com', NULL)
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Image]) VALUES (N'tuna', N'123', N'Phạm Minh Tuấn', N'tuanpham150801@gmail.com', N'tuan.jpg')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [Image]) VALUES (N'valne', N'123', N'Lê Văn Cường', N'cuongg121101@gmail.com', NULL)
SET IDENTITY_INSERT [dbo].[Authorities] ON 

INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (1, N'valne', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (2, N'tuna', N'USER')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (3, N'tuna', N'GUEST')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (4, N'khoa', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (5, N'khoa', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (6, N'khoa', N'ADMIN')
SET IDENTITY_INSERT [dbo].[Authorities] OFF
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([Id], [Name]) VALUES (1, N'Act')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (2, N'Role - playing')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (3, N'Tactic')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (4, N'Sports')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (5, N'Xbox')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (6, N'Consoles & Accessories')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (7, N'Board game')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (8, N'Countervailing')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (9, N'Coming soon')
SET IDENTITY_INSERT [dbo].[Categories] OFF
SET IDENTITY_INSERT [dbo].[Favorities] ON 

INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (4, 1, N'valne', CAST(N'2021-08-02' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (5, 3, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (6, 3, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (7, 3, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (8, 2, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (9, 3, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (10, 1, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (11, 2, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (12, 4, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (13, 4, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (14, 1, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (15, 4, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (16, 4, NULL, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (17, 3, N'valne', CAST(N'2021-08-03' AS Date))
INSERT [dbo].[Favorities] ([Id], [ProductId], [Username], [CreateDate]) VALUES (18, 3, N'Valne', CAST(N'2021-08-04' AS Date))
SET IDENTITY_INSERT [dbo].[Favorities] OFF
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([Id], [OrderId], [ProductId], [Price], [Quantity]) VALUES (48, 48, 4, 250, 1)
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [ProductId], [Price], [Quantity]) VALUES (49, 48, 3, 199, 1)
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [ProductId], [Price], [Quantity]) VALUES (50, 49, 2, 299, 1)
INSERT [dbo].[OrderDetails] ([Id], [OrderId], [ProductId], [Price], [Quantity]) VALUES (51, 50, 4, 250, 1)
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([Id], [Username], [CreateDate], [Address], [Status]) VALUES (48, N'valne', CAST(N'2021-08-08' AS Date), N'Van Cuong', 1)
INSERT [dbo].[Orders] ([Id], [Username], [CreateDate], [Address], [Status]) VALUES (49, N'tuna', CAST(N'2021-08-08' AS Date), N'Minh Tuan', 0)
INSERT [dbo].[Orders] ([Id], [Username], [CreateDate], [Address], [Status]) VALUES (50, N'valne', CAST(N'2021-08-09' AS Date), N'tuannef', 1)
SET IDENTITY_INSERT [dbo].[Orders] OFF
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Price], [CreateDate], [Image], [Available], [Description], [Category]) VALUES (1, N'World War Z', 399, CAST(N'2021-07-01' AS Date), N'product-5.jpg', 1, N'Coming soon', 9)
INSERT [dbo].[Products] ([Id], [Name], [Price], [CreateDate], [Image], [Available], [Description], [Category]) VALUES (2, N'The
 Handsome Collection', 299, CAST(N'2021-04-01' AS Date), N'product-3.jpg', 1, N'Sports', 4)
INSERT [dbo].[Products] ([Id], [Name], [Price], [CreateDate], [Image], [Available], [Description], [Category]) VALUES (3, N'The Witcher 3: Wild
 Hunt', 199, CAST(N'2021-07-01' AS Date), N'product-4.jpg', 1, N'Act', 1)
INSERT [dbo].[Products] ([Id], [Name], [Price], [CreateDate], [Image], [Available], [Description], [Category]) VALUES (4, N'Tom Clancy’s
Ghost Recon Wildlands', 250, CAST(N'2021-07-30' AS Date), N'product-6.jpg', 1, N'Act', 1)
INSERT [dbo].[Products] ([Id], [Name], [Price], [CreateDate], [Image], [Available], [Description], [Category]) VALUES (12, N'game 1', 123, CAST(N'2021-08-08' AS Date), N'aa505670.jpg', 1, N'Role', 2)
SET IDENTITY_INSERT [dbo].[Products] OFF
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'ADMIN', N'Adminastrator')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'GUEST', N'Guest')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'USER', N'User')
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK__Authoriti__RoleI__15502E78] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK__Authoriti__RoleI__15502E78]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK__Authoriti__Usern__145C0A3F] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK__Authoriti__Usern__145C0A3F]
GO
ALTER TABLE [dbo].[Favorities]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[Favorities]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK__OrderDeta__Order__1FCDBCEB] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK__OrderDeta__Order__1FCDBCEB]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK__OrderDeta__Produ__20C1E124] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK__OrderDeta__Produ__20C1E124]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK__Products__Catego__1CF15040] FOREIGN KEY([Category])
REFERENCES [dbo].[Categories] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK__Products__Catego__1CF15040]
GO
USE [master]
GO
ALTER DATABASE [GameStore] SET  READ_WRITE 
GO
