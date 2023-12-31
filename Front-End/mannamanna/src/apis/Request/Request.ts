// Request 타입 정의

export interface LoginReq {
  id: string;
  pwd: string;
}

export interface FindidReq {
  name: string;
  emailId: string;
  emailDomain: string;
}

export interface FindidReq {
  name: string;
  emailId: string;
  emailDomain: string;
}

export interface FindpwReq {
  id: string;
  emailId: string;
  emailDomain: string;
}

//회원가입시 받는 회원 정보
export type RegisterReq = {
  id: string;
  pwd: string;
  name: string;
  gender: any; //api
  tel: string;
  birth: string;
  emailId: string; //api
  emailDomain: string; //api
  height: number;
  job: string;
  isSmoker: boolean;
  isDrinker: boolean;
  mbti: string;
  religion: string;
  introduction: string;
  sido: string;
  gugun: string;
  detail: string;
  latitude: number; //api
  longitude: number; //api
};

export interface MessageReq {
  receiver: string;
  sender: string;
  subject: string;
  content: string;
  isSogae: boolean;
  date: string;
}

export interface SogaetingReq {
  receiver: string;
  sender: string;
  date: string;
}

export interface SogaetingFilterReq {
  memberId: string | null;
  gender: string | null;
  mbti: string | null;
  religion: string | null;
  isDrinker: boolean | null;
  isSmoker: boolean | null;
  curPage:number
}

export interface SogaetingRecommandReq {
  mbti: string | null;
  religion: string | null;
  isDrinker: boolean | null;
  isSmoker: boolean | null;
}

export interface DetailScheduleReq {
  userId:string | null;
  date:string | null;
}

export interface ChatMessage{
  MessageType: string|null;
  roomId:number|null;
  senderId:string|null;
  senderName:string|null;
  message:string|null;
}


export interface MissionDoReq{
  memberId: string|null;
  id:number|null;
  missionId:number|null;
  gender:string|null;
}

export interface MakeChatRoom{
  maleId:string|null;
  femaleId:string|null;

}