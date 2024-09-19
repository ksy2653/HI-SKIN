# 💄 HI-SKIN
<img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/hiskin%20logo.png" alt="Hiskin Logo" width="400">
<br>

## 프로젝트 소개
- 본 프로젝트는 LG 전자와 협업하여 진행한 소프트웨어 공학 프로젝트입니다.
- LG Pra.L 상품과 같이 사용할 사용자 맞춤형 스킨케어 어플리케이션 제작을 목표
<br>

## 프로젝트 기간 및 인원
프로젝트 기간: 2023년 9월 1일 ~ 12월 15일  
프로젝트 인원: 총 4명  

- OOO: Front-End, UI/UX
- OOO: Back-End, Documentation
- OOO: AI
- OOO: Research, Documentation

</div>

<br>

## 1. 개발 환경
- Front : React-Native, Expo
- Back-end : SpringBoot, Hibernate, AWS EC2, Github Actions
- 협업 툴 : Notion, Github, Zoom, Figma

<br>

## 2. System Architecture

![architecture](http://github.com/ksy2653/HI-SKIN/raw/main/hiskin%20architecture.png)

<br>

## 3. ERD

![erd](http://github.com/ksy2653/HI-SKIN/raw/main/erd.png)

## 4. 핵심 기능

> **1. Login and Sign Up**
>
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/login.png" alt="login" width="250">
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/signup.png" alt="signup" width="250">
>
> - 사용자 맞춤형 스킨케어 서비스를 제공하기 위해 로그인을 진행합니다.
> - 이름, ID, Password, 성별, 닉네임을 입력하면 회원가입이 완료되고 정보는 DB에 저장합니다.
<br>

> **2. Skin Type Test**
>
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/test.png" alt="test" width="250">
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/result.png" alt="result" width="250">
>
> - 사용자는 바우만 피부 타입 테스트를 진행하고 피부타입을 진단 받습니다.
> - 피부타입은 총 16가지가 존재하고 각 피부타입 별 스킨케어 솔루션을 제공합니다.
> - 사용자의 피부타입은 DB에 저장됩니다.
<br>

> **3. Cosmetic Recommendation**
>
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/cosmetics.png" alt="cosmetics" width="250">
>
> - 사용자는 피부 타입에 맞는 화장품을 추천받을 수 있습니다.
> - 화장품은 올리브영 사이트에서 피부타입별 추천 상품을 크롤링하여 추천해줍니다.
<br>

> **4. Skin Care Challenge**
>
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/challenge.png" alt="test" width="750">
>
> - 사용자는 매일 피부 챌린지를 하여 점수를 받습니다.
> - 피부 챌린지를 하며 자연스럽게 스킨 케어 루틴을 형성할 수 있습니다.
<br>

> **5. My page**
>
> <img src="https://raw.githubusercontent.com/ksy2653/HI-SKIN/main/ui/report.png" alt="report" width="550">
>
> - 사용자는 피부 챌린지 점수의 리포트를 확인할 수 있습니다.
> - 이를 통해 사용자는 자신의 스킨 케어 루틴이 잘 지켜졌는지 확인이 가능합니다.
<br>

## 5. 개발 문서
<a href="https://github.com/ksy2653/HI-SKIN/blob/main/HISKIN_Documentation.pdf">HISKIN Documentation</a>
<br>

## 6. CI/CD
![cicd](http://github.com/ksy2653/HI-SKIN/raw/main/cicd.png)
