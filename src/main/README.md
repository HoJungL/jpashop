H2 DB를 열어놓은 상황에서 실행시켰을때, 안되는이유 -> 서버 파일이 tcp가 아니기 떄문입니다.
따라서, 이를 해결하기 위해서는 persistence.xml파일에서 server의 value를 tcp로 설정햬서 만들어야합니다.
해당 오류는 "https://workshop-6349.tistory.com/entry/%EC%9C%84%EB%8C%80%ED%95%9C-%EC%82%BD%EC%A7%88-H2-database-file-is-locked" 에서 참고하였습니다.

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속
에서 Joined를 하면 각각 테이블이 생성이 됩니다.
하지만, Single_Table로 하면 extends하는 테이블(Album등)이 생성되지 않아요.
여기서 문제는..!! join을 했다가 single로 바꿔놓으면, 이전에 만들어졌던 album table이 삭제가 되지 않습니다..!!
이부분은 직접 DB로 들어가서 drop table을 해주셔야해요..!!