USE [master]
GO
/****** Object:  Database [MultiChat]    Script Date: 4/13/2021 7:22:28 AM ******/
CREATE DATABASE [MultiChat]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MultiChat', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MultiChat.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MultiChat_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MultiChat_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MultiChat] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MultiChat].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MultiChat] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MultiChat] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MultiChat] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MultiChat] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MultiChat] SET ARITHABORT OFF 
GO
ALTER DATABASE [MultiChat] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MultiChat] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [MultiChat] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MultiChat] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MultiChat] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MultiChat] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MultiChat] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MultiChat] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MultiChat] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MultiChat] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MultiChat] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MultiChat] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MultiChat] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MultiChat] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MultiChat] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MultiChat] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MultiChat] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MultiChat] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MultiChat] SET RECOVERY FULL 
GO
ALTER DATABASE [MultiChat] SET  MULTI_USER 
GO
ALTER DATABASE [MultiChat] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MultiChat] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MultiChat] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MultiChat] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'MultiChat', N'ON'
GO
USE [MultiChat]
GO
/****** Object:  StoredProcedure [dbo].[login]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[login] @us nvarchar(50), @pw nvarchar(225), @rs int output
as
begin
	set @rs = (select COUNT(*) from users where username=@us and password = @pw)
end

GO
/****** Object:  StoredProcedure [dbo].[register]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[register] @us nvarchar(50), @pw nvarchar(225)
as
begin
	insert into users values(@us,@pw)
end

GO
/****** Object:  StoredProcedure [dbo].[stt]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[stt] @stt int output
as
begin
	set @stt = (select * from serverstatus)
end

GO
/****** Object:  StoredProcedure [dbo].[updateS]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateS] @stt int
as
begin
	update serverstatus
	set status=@stt
end

GO
/****** Object:  Table [dbo].[serverstatus]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[serverstatus](
	[status] [int] NOT NULL,
 CONSTRAINT [PK_serverstatus] PRIMARY KEY CLUSTERED 
(
	[status] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 4/13/2021 7:22:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](225) NOT NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[serverstatus] ([status]) VALUES (0)
INSERT [dbo].[users] ([username], [password]) VALUES (N'hohien', N'3')
INSERT [dbo].[users] ([username], [password]) VALUES (N'jjj', N'44')
INSERT [dbo].[users] ([username], [password]) VALUES (N'loc', N'1')
INSERT [dbo].[users] ([username], [password]) VALUES (N'loc2', N'2')
INSERT [dbo].[users] ([username], [password]) VALUES (N'locnguyen', N'1')
INSERT [dbo].[users] ([username], [password]) VALUES (N'phannguyen', N'2')
INSERT [dbo].[users] ([username], [password]) VALUES (N'phuloc', N'1')
INSERT [dbo].[users] ([username], [password]) VALUES (N'tttttt', N'5')
INSERT [dbo].[users] ([username], [password]) VALUES (N'yyy', N'tt')
INSERT [dbo].[users] ([username], [password]) VALUES (N'yyyyyy', N't')
USE [master]
GO
ALTER DATABASE [MultiChat] SET  READ_WRITE 
GO
