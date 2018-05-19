//响应ajax后台函数，使用mongodb
@RequestMapping(value = "/func", method = RequestMethod.POST)
@ResponseBody
public String func(HttpServletRequest request) throws UnsupportedEncodingException {
		String res = "";
		String Id="";
		int requestNums=0;
		final Map<String, Object> mapp = new HashMap<String, Object>();		

		Items item = mongoTemplate.find(new ObjectId(Id),Items.class,"");
		if(item.get()!=null){
			requestNums=(item.get()).size();
		}
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();	
		if(list!=null){
			if(item.get()!=null){
				for(AgentExec agent:item.get()){
					Map<String,String> map = new HashMap<String,String>(); 
					map.put("","");
					list.add(map);
				}	
			}
		}	
	
		mapp.put("cnt",requestNums);
		mapp.put("info",list);
		res = net.sf.json.JSONObject.fromObject(mapp).toString();
        return res;
	}

//获取参数内容
request.getParameterValues("namesArray");
