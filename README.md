# FinaluriMangKac
მანგა
Login activity
        აპლიკაციის გაშვებისას პირველ რიგში გვხვდება Login Activiy, სადაც მოთავსებული არის 3 Button-ი:Login, Register და Reset Password. ჩვენი მონაცემების შეყვანის შემდეგ Login Button-ის საშუალებით გადავდივართ HomeFragment-ზე, Register Button-ის საშუალებით გადავდივართ Register Activity-ზე, ხოლო ResetPassword-ის საშუალებით კი...Reset Activity-ზე
RegistrerActivity
     RegisterActivity-ზე გადასვლის შემდეგ ჩვენ გვხვდება ცარიელი ველები და Register Confirm Button-ი. ცარიელ ველებში ჩვენ უნდა შევიყვანოთ ჩვენი სახელი, გვარი, დაბადების თარიღი, პაროლი და მეილი, და ამ ყველაფრის შეყვანის შემდეგ ვაჭერთ ვაჭერთ RegisterConfirmButton-ს , რომელის საშუალებითაც გადავდივართ HomeFragment-ზე.
ResetActivity
      ამ Activity-ში არის მხოლოდ ერთი ველი და ერთ Button-ი. ამ ცარიელ ველში ჩვენ უნდა დავწეროთ ჩვენი @Mail მისამართი და  Confirmation Button-ზე დაჭერის შემდეგ ჩვენ მოგვივა mail-ი, სადაც ლინკი იქნება მოცემული, რომლის საშუალებითაც პაროლს ავღადგენთ.
 ამ ყველაფერს FireBase-ის საშუალებით ვაკეთებთ.
HomeFragment
      ჩვენს აპლიკაციაში არის 3 Fragment-ი: HomeFragment, PersonInfoFragment და MusicListFragment. HomeFragment-ში იქნება მანგების ჩამონათვალი და რომელიმეზე დაჭერის შემთხვევაში გადავდივართ ViewPager-ში.
RecycleView
        RecycleView-ში გადასვლის შემდეგ ვირჩევთ იმ Chapters, რომლის წაკითხვაც გვინდა
MusicListFragment
    ამ აქტივიტიში ჩვენ ვირჩევთ მუსიკას, რომელიც მანგის წაკითხვისას უკანა ფონზე დაიკვრება. მოცემული არის სულ 4 ტიპის მუსიკა.
PersonInfoActivity
    PersonInfoActiviy-ში მოემული არის ის ინფორმაცია, რომელიც რეგისტრაციისას გამოვიყენეთ. ესენია: სახელი, გვარი და ასაკი. ასევე შეგვიძლია URL-თი ფოტოს ატვირთვა. ამ ყველაფერთან ერთად არის ორი Button-ი LogOut და ChangePassword. LogOut-ზე დაჭერისას გავდივართ ჩვენი ექაუნთიდან და გადავდივარ LoginActivity-ში. ChangePassword-ის საშუალებით კი გადავდივართ ChangePasswordActivity-ში.

ChangePasswordActivity
     ChangePasswordActivity-ში გადასვლისას  გვხვდება ორი ცარიელი ველი და ერთი Button-ი. პირველ ცარიელ ველში უნდა შევიყვანოთ ჩვენი პაროლი და მეორეში კი ახალი პაროლი. პაროლების შეყვანის შემდეგ Confirmation Button-ის საშუალებით ჩვენ ვცვლით ჩვენ პაროლს და უკან ვბრუნდებით PersonInfoActivity-ში.
     
     
     მონაწილეობდნენ: ვახტანგი ჯიქიძე, ნიკოლოზ ბელთაძე, მუთალიმა ოსმანოვი
