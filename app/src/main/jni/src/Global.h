#ifndef ANDROID_MOD_MENU_GLOBAL_H
#define ANDROID_MOD_MENU_GLOBAL_H

struct {

    uintptr_t MainCameraTransform = 0x50;  // public Transform MainCameraTransform; // 0x50  (1.54.2)
    uintptr_t Dictionary = 0x44; // protected Dictionary<byte, Player> b]T^b|Q; // 0x44  (1.54.2)
    uintptr_t HeadTF = 0x1B0; // protected Transform s^uN~t; // 0x1A4  (1.54.2)
    uintptr_t HipTF = 0x1B4; // protected Transform sqdz[Xb; // 0x1A8  (1.54.2)
    uintptr_t HandTF = 0x1AC; // protected Transform {vps^o; // 0x1A0  (1.54.2)
    uintptr_t EyeTF = 0x1B8; // protected Transform mB]ByDk; // 0x1AC  (1.54.2)
    uintptr_t ToeTF = 0x1C0; // protected Transform hFLM]|b; // 0x1B4  (1.54.2)
    uintptr_t RightShoulder = 0x1E0; // protected Transform OjNRJt; // 0x1D4  (1.54.2)
    uintptr_t LeftShoulder = 0x1DC; // protected Transform mcbhyOv; // 0x1D0  (1.54.2)
    uintptr_t IsClientBot = 0xC4; // public bool IsClientBot; // 0xC4  (1.54.2)
    uintptr_t U3DStr = 0x22107D0; // 1.54.2
    uintptr_t U3DStrConcat = 0x220EF70; // 1.54.2
    uintptr_t Component_GetTransform = 0x27A593C; // public Transform get_transform() 1.54.2
    uintptr_t GetCameraTrackableEntityTransfrom = 0xB473C0; // public Transform GetCameraTrackableEntityTransfrom 1.54.2
    uintptr_t Transform_INTERNAL_GetPosition = 0x2ABF900; // private void INTERNAL_get_position 1.54.2
    uintptr_t Transform_INTERNAL_SetPosition = 0x2ABF9C0; // private void INTERNAL_set_position 1.54.2
    uintptr_t GetForward = 0x2ABFFE4; // public Vector3 get_forward 1.54.2
    uintptr_t get_isAlive = 0xB474D4; // public bool IsCameraTrackableEntityAlive 1.54.2
    uintptr_t GetPhysXPose = 0xB6C420; // public xl^LGZc GetPhysXPose 1.54.2
    uintptr_t IsFiring = 0xB7F1AC; // public bool IsFiring 1.54.2
    uintptr_t IsCrouching = 0xB6C454; // public bool IsCrouching 1.54.2
    uintptr_t get_IsSighting = 0xBB568C; // public bool get_IsSighting 1.54.2
    uintptr_t get_IsReallyDead = 0xB62A70; // public bool get_IsReallyDead 1.54.2
    uintptr_t get_isLocalPlayer = 0xB62540; // public bool IsLocalPlayer 1.54.2
    uintptr_t get_isLocalTeam = 0xB6AA08; // public virtual bool IsLocalTeammate 1.54.2
    uintptr_t get_isVisible = 0xB64180; // public override bool IsVisible 1.54.2
    uintptr_t set_aim = 0xB624F8; // public void SetAimRotation 1.54.2
    uintptr_t Camera_main_fov = 0x27A0E68; // public float get_fieldOfView 1.54.2
    uintptr_t get_imo = 0xB4DB74; // public FPnavhE GetActiveWeapon 1.54.2
    uintptr_t set_esp = 0xC84B4C; //	public void fxZep 1.54.2
    uintptr_t GetAttackableCenterWS = 0xB610BC; // public override Vector3 GetAttackableCenterWS 1.54.2
    uintptr_t GetCharacterControllerTopPosition = 0xBA0084; // public virtual Vector3 GetCharacterControllerTopPosition 1.54.2
    uintptr_t get_NickName = 0xB45728; // public string get_NickName 1.54.2
    uintptr_t WorldToScreenPoint = 0x27A27D8; // public Vector3 WorldToScreenPoint 1.54.2
    uintptr_t get_height = 0x2AB461C; // public static int get_height 1.54.2
    uintptr_t get_width = 0x2AB458C; // public static int get_width 1.54.2
    uintptr_t get_deltaTime = 0x2ABE784; // public static float get_fixedDeltaTime 1.54.2
    uintptr_t CurrentUIScene = 0x207E01C; // public static UICOWBaseScene CurrentUIScene 1.54.2
    uintptr_t Curent_Match = 0x2092268; // public static Th|G[l[ CurrentMatch 1.54.2
    uintptr_t Current_Local_Player = 0x20925BC; // public static Player CurrentLocalPlayer 1.54.2
    uintptr_t GetLocalPlayerOrObServer = 0x2093860; // public static Player GetLocalPlayerOrObServer 1.54.2
    uintptr_t CurrentLocalSpectator = 0x2092A3C; // public static olfyRLw CurrentLocalSpectator() 1.54.2
    uintptr_t Player_Index = 0x1A89FE0; // public Player ]xBnHak(byte WMRg}) { } 1.54.2
    uintptr_t AddTeammateHud = 0x1155D34; //	public void ShowAssistantText(string playerName, string line) { } 1.54.2
    uintptr_t spof_uid = 0xB614DC; // protected void kjkIWoo(ulong aKRQdu) { } 1.54.2
    uintptr_t spof_nick = 0xB615CC; // protected void rhTOWJa(string aKRQdu) { } 1.54.2
    uintptr_t ShowDynamicPopupMessage = 0x1141E54; // public void ShowDynamicPopupMessage(string message, float duration = 5) { } 1.54.2
    uintptr_t ShowPopupMessage = 0x1141FDC; //	public void ShowPopupMessage(string message, float duration = 2) { } 1.54.2
    uintptr_t GetLocalPlayer = 0x1FDF980; // private static Player GetLocalPlayer() { } 1.54.2
    uintptr_t GetCharacterHeight = 0xB735B0; // public float GetCharacterHeight() 1.54.2
    uintptr_t set_height = 0x27A42E0; // public void set_height(float value) { } 1.54.2
    uintptr_t get_CharacterController = 0xB61928; // public CharacterController get_CharacterController() 1.54.2
    uintptr_t IsUserControlChanged = 0xB6C338; // public bool IsUserControlChanged() 1.54.2
    uintptr_t set_invitee_nickname = 0x2C55DC4; // public void set_invitee_nickname(string value) { } 1.54.2
    uintptr_t Raycast = 0x2A57184; // public static bool Raycast(Vector3 origin, Vector3 direction, float maxDistance, int layerMask) { } 1.54.2
    uintptr_t get_MyFollowCamera = 0xB61E7C; // public FollowCamera get_MyFollowCamera() 1.54.2
    uintptr_t IsSameTeam = 0x1848054; // protected override void OnUIInit() 1.54.2
    uintptr_t AttackableEntity_GetIsDead = 0x2316ECC; // public bool get_IsDead() 1.54.2
    uintptr_t AttackableEntity_IsVisible = 0x232AE04; // public virtual bool IsVisible() 1.54.2
    uintptr_t Camera_WorldToScreenPoint = 0x27A27D8; // public Vector3 WorldToScreenPoint(Vector3 position)1.54.2
    uintptr_t Camera_main = 0x27A2DC8; // public static Camera get_main 1.54.2
    uintptr_t telamento2 = 0x1C74E08; // public int get_CurrentSpectatorCount 1.54.2
    uintptr_t telamentoforce = 0x2C5B2E8; // public uint[] get_spectators() 1.54.2
    uintptr_t noRecoil = 0x179EF54; // public float GetScatterRate 1.54.2
    uintptr_t GetHead = 0xB9FCBC; // 1.54.2  
    uintptr_t GetHipTF = 0xB9FDE8; // 1.54.2
    uintptr_t CurrentMatch = 0x2092268; // 1.54.2
    uintptr_t GetLocalPlayer2 = 0x1A89B48; // 1.54.2
    uintptr_t getPlayerByIndex = 0x1A89FE0; // 1.54.2
    uintptr_t get_CurHP = 0xB93D68; // 1.54.2
    uintptr_t get_PlayerID = 0xB41BCC; // 1.54.2
    uintptr_t get_IsDieing = 0xB61D88; // 1.54.2
    uintptr_t get_IsSkyDiving = 0xB4D998; // 1.54.2
    uintptr_t get_IsSkyDashing = 0xB63910; // 1.54.2
    uintptr_t get_IsParachuting = 0xB4D9F0; // 1.54.2
    uintptr_t SetAimRotation = 0xB624F8; // 1.54.2
    uintptr_t get_MaxHP = 0x1F616D8; // 1.54

    uintptr_t il2cpp_string_new = 0x2E2CE0C; // 1.53.2  no DUMP
    uintptr_t String_Concat = 0x2200BA0; // 1.54.2
    uintptr_t Screen_get_width = 0x2AB458C; // 1.54.2
    uintptr_t Screen_get_height = 0x2AB461C; // 1.54.2
    uintptr_t get_IsCrouching = 0xB6C454; // 1.54.2
    uintptr_t get_main = 0x27A2DC8; // 1.54.2
    uintptr_t Component_get_transform = 0x27A593C; // 1.54.2
    uintptr_t Transform_get_position = 0x2ABF900; // 1.54.2
    uintptr_t IsVisible = 0xB64180; // 1.54.2
    uintptr_t IsLocalPlayer = 0xB62540; // 1.54.2
    uintptr_t Transform_get_forward = 0x2ABFFE4;  // 1.54.2
    uintptr_t IsLocalTeammate = 0xB6AA08; // 1.54.2

} Global;

#endif
