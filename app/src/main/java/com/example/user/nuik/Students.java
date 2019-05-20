package com.example.user.nuik;

public class Students {

        private String StudentNum;
        private String StudenttName;
        private String StudentPrenom;
        private String StudentPar;
        private String StudentSp;
        private String StudentGroup;
        private String StudentNiveau;

        public Students(String studentNum, String studenttName, String studentPrenom, String studentPar, String studentSp, String studentGroup, String studentNiveau) {
            StudentNum = studentNum;
            StudenttName = studenttName;
            StudentPrenom = studentPrenom;
            StudentPar = studentPar;
            StudentSp = studentSp;
            StudentGroup = studentGroup;
            StudentNiveau = studentNiveau;
        }


        public String getStudentNum() {
            return StudentNum;
        }

        public void setStudentNum(String studentNum) {
            StudentNum = studentNum;
        }

        public String getStudenttName() {
            return StudenttName;
        }

        public void setStudenttName(String studenttName) {
            StudenttName = studenttName;
        }

        public String getStudentPrenom() {
            return StudentPrenom;
        }

        public void setStudentPrenom(String studentPrenom) {
            StudentPrenom = studentPrenom;
        }

        public String getStudentPar() {
            return StudentPar;
        }

        public void setStudentPar(String studentPar) {
            StudentPar = studentPar;
        }

        public String getStudentSp() {
            return StudentSp;
        }

        public void setStudentSp(String studentSp) {
            StudentSp = studentSp;
        }

        public String getStudentGroup() {
            return StudentGroup;
        }

        public void setStudentGroup(String studentGroup) {
            StudentGroup = studentGroup;
        }

        public String getStudentNiveau() {
            return StudentNiveau;
        }

        public void setStudentNiveau(String studentNiveau) {
            StudentNiveau = studentNiveau;
        }

}
